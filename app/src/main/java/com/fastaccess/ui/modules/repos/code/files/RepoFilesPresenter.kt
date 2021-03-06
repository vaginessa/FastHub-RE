package com.fastaccess.ui.modules.repos.code.files

import android.view.View
import com.fastaccess.R
import com.fastaccess.data.dao.CommitRequestModel
import com.fastaccess.data.dao.FileOrTree
import com.fastaccess.data.dao.Pageable
import com.fastaccess.data.dao.RepoPathsManager
import com.fastaccess.data.dao.model.RepoFile
import com.fastaccess.helper.RxHelper.getObservable
import com.fastaccess.provider.rest.RestProvider.getContentService
import com.fastaccess.provider.rest.RestProvider.getRepoService
import com.fastaccess.ui.base.mvp.presenter.BasePresenter
import com.fastaccess.ui.modules.repos.code.commit.history.FileCommitHistoryActivity.Companion.startActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import java.lang.reflect.Type

inline fun <reified T> genericType(): Type = object : TypeToken<T>() {}.type

/**
 * Created by Kosh on 15 Feb 2017, 10:10 PM
 */
class RepoFilesPresenter : BasePresenter<RepoFilesMvp.View>(), RepoFilesMvp.Presenter {
    override val files = ArrayList<RepoFile>()
    private val pathsModel = RepoPathsManager()

    @JvmField
    @com.evernote.android.state.State
    var repoId: String? = null

    @JvmField
    @com.evernote.android.state.State
    var login: String? = null

    @JvmField
    @com.evernote.android.state.State
    var path: String? = null

    @JvmField
    @com.evernote.android.state.State
    var ref: String? = null
    override fun onItemClick(position: Int, v: View?, item: RepoFile) {
        if (view == null) return
        if (v!!.id != R.id.menu) {
            view!!.onItemClicked(item)
        } else {
            view!!.onMenuClicked(position, item, v)
        }
    }

    override fun onItemLongClick(position: Int, v: View?, item: RepoFile) {
        startActivity(v!!.context, login!!, repoId!!, ref!!, item.path, isEnterprise)
    }

    override fun onError(throwable: Throwable) {
        onWorkOffline()
        super.onError(throwable)
    }

    override fun onWorkOffline() {
        if (repoId == null || login == null || files.isNotEmpty()) return
        manageDisposable(
            getObservable(
                RepoFile.getFiles(
                    login!!, repoId!!
                ).toObservable()
            )
                .flatMap { response ->
                    Observable.fromIterable(response)
                        .filter { repoFile: RepoFile? -> repoFile != null && repoFile.type != null }
                        .sorted { repoFile: RepoFile, repoFile2: RepoFile ->
                            repoFile2.type.compareTo(
                                repoFile.type
                            )
                        }
                }
                .toList()
                .subscribe { models ->
                    files.addAll(models!!)
                    sendToView { v -> v.onNotifyAdapter(files) }
                })
    }

    fun onFiles(resp: Observable<Pageable<RepoFile>>, toAppend: RepoFile?) {
        makeRestCall(
            resp.flatMap { response ->
                if (response.items != null) {
                    return@flatMap Observable.fromIterable(response.items)
                        .filter { repoFile: RepoFile -> repoFile.type != null }
                        .sorted { repoFile: RepoFile, repoFile2: RepoFile ->
                            repoFile2.type.compareTo(
                                repoFile.type
                            )
                        }
                }
                Observable.empty()
            }
                .toList().toObservable()
        ) { response ->
            files.clear()
            if (response != null) {
                manageObservable(RepoFile.save(response, login!!, repoId!!))
                pathsModel.setFiles(ref!!, path!!, response)
                files.addAll(response)
            }
            sendToView { view ->
                view.onNotifyAdapter(files)
                view.onUpdateTab(toAppend)
            }
        }
    }

    fun onFile(resp: Observable<RepoFile>) {
        makeRestCall(resp) { file ->
            sendToView {
                it.onNotifyFile(file)
            }
        }
    }

    override fun onCallApi(toAppend: RepoFile?) {
        if (repoId == null || login == null) return
        manageDisposable(
            getObservable(
                getRepoService(isEnterprise).getRepoFiles(
                    login!!, repoId!!, path!!, ref!!
                )
            ).subscribe { response: okhttp3.ResponseBody ->
                val bytes = response.string()
                val gson = Gson()
                val type = genericType<FileOrTree>()
                val resp = gson.fromJson<FileOrTree>(bytes, type)
                when (resp.type) {
                    "file" -> {
                        val type1 = genericType<RepoFile>()
                        val resp1 = gson.fromJson<RepoFile>(bytes, type1)
                        onFile(Observable.just(resp1))
                    }
                    else -> {
                        val type1 = genericType<Pageable<RepoFile>>()
                        val resp1 = gson.fromJson<Pageable<RepoFile>>(bytes, type1)
                        onFiles(Observable.just(resp1), toAppend)
                    }
                }
            })
    }

    override fun onInitDataAndRequest(
        login: String, repoId: String, path: String,
        ref: String, clear: Boolean, toAppend: RepoFile?
    ) {
        if (clear) pathsModel.clear()
        this.login = login
        this.repoId = repoId
        this.ref = ref
        this.path = path
        val cachedFiles = getCachedFiles(path, ref)
        if (cachedFiles != null && cachedFiles.isNotEmpty()) {
            files.clear()
            files.addAll(cachedFiles)
            sendToView { view: RepoFilesMvp.View ->
                view.onNotifyAdapter(files)
                view.onUpdateTab(toAppend)
            }
        } else {
            onCallApi(toAppend)
        }
    }

    override fun getCachedFiles(url: String, ref: String): List<RepoFile>? {
        return pathsModel.getPaths(url, ref)
    }

    override fun onDeleteFile(message: String, item: RepoFile, branch: String) {
        val body = CommitRequestModel(message, null, item.sha, branch)
        makeRestCall(
            getContentService(isEnterprise)
                .deleteFile(login!!, repoId!!, item.path, ref!!, body)
        ) {
            sendToView { it.onRefresh() }
        }
    }
}