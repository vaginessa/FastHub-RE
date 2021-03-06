package com.fastaccess.ui.modules.trending.fragment

import android.os.Bundle
import android.view.View
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.evernote.android.state.State
import com.fastaccess.R
import com.fastaccess.data.dao.TrendingModel
import com.fastaccess.ui.adapter.TrendingAdapter
import com.fastaccess.ui.base.BaseFragment
import com.fastaccess.ui.delegate.viewFind
import com.fastaccess.ui.widgets.StateLayout
import com.fastaccess.ui.widgets.recyclerview.DynamicRecyclerView
import com.fastaccess.ui.widgets.recyclerview.scroll.RecyclerViewFastScroller

/**
 * Created by Kosh on 30 May 2017, 11:37 PM
 */

class TrendingFragment : BaseFragment<TrendingFragmentMvp.View, TrendingFragmentPresenter>(),
    TrendingFragmentMvp.View {
    val recycler: DynamicRecyclerView by viewFind(R.id.recycler)
    val refresh: SwipeRefreshLayout by viewFind(R.id.refresh)
    val stateLayout: StateLayout by viewFind(R.id.stateLayout)
    val fastScroller: RecyclerViewFastScroller by viewFind(R.id.fastScroller)

    private val adapter by lazy { TrendingAdapter(presenter.getTendingList()) }

    @State
    var lang: String = ""

    @State
    var since: String = ""

    override fun providePresenter(): TrendingFragmentPresenter = TrendingFragmentPresenter()

    override fun fragmentLayout(): Int = R.layout.small_grid_refresh_list

    override fun onFragmentCreated(view: View, savedInstanceState: Bundle?) {
        stateLayout.setEmptyText(R.string.no_trending)
        recycler.setEmptyView(stateLayout, refresh)
        refresh.setOnRefreshListener { onCallApi() }
        stateLayout.setOnReloadListener { onCallApi() }
        adapter.listener = presenter
        recycler.adapter = adapter
        fastScroller.attachRecyclerView(recycler)
    }

    override fun onNotifyAdapter(items: List<TrendingModel>) {
        adapter.insertItems(items)
    }

    override fun onSetQuery(lang: String, since: String) {
        this.lang = lang
        this.since = since
        adapter.clear()
        presenter.onCallApi(lang, since)
    }

    override fun showProgress(resId: Int) {
        refresh.isRefreshing = true
        stateLayout.showProgress()
    }

    override fun hideProgress() {
        refresh.isRefreshing = false
        stateLayout.hideProgress()
        stateLayout.showReload(adapter.itemCount)
    }

    override fun showMessage(titleRes: Int, msgRes: Int) {
        hideProgress()
        super.showMessage(titleRes, msgRes)
    }

    override fun showMessage(titleRes: String, msgRes: String) {
        hideProgress()
        super.showMessage(titleRes, msgRes)
    }

    override fun showErrorMessage(msgRes: String) {
        hideProgress()
        super.showErrorMessage(msgRes)
    }

    private fun onCallApi() {
        presenter.onCallApi(lang, since)
    }

    override fun clearAdapter() {
        adapter.clear()
    }
}