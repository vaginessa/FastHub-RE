package com.fastaccess.data.service

import com.fastaccess.BuildConfig
import com.fastaccess.data.dao.CommitRequestModel
import com.fastaccess.data.dao.GitCommitModel
import com.fastaccess.data.dao.GithubStatusComponentsModel
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by kosh on 29/08/2017.
 */
interface ContentService {

    @PUT("repos/{owner}/{repoId}/contents/{path}")
    fun updateCreateFile(@Path("owner") owner: String,
                         @Path("repoId") repoId: String,
                         @Path("path") path: String,
                         @Query("branch") branch: String,
                         @Body body: CommitRequestModel): Observable<GitCommitModel>

    @HTTP(method = "DELETE", path = "repos/{owner}/{repoId}/contents/{path}", hasBody = true)
    fun deleteFile(@Path("owner") owner: String,
                   @Path("repoId") repoId: String,
                   @Path("path") path: String,
                   @Query("branch") branch: String,
                   @Body body: CommitRequestModel): Observable<GitCommitModel>

    @GET(BuildConfig.GITHUB_STATUS_COMPONENTS_PATH)
    fun checkStatus(): Observable<GithubStatusComponentsModel>
}