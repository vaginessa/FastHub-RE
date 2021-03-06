package com.fastaccess.ui.modules.repos.extras.branches.pager

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.fastaccess.R
import com.fastaccess.data.dao.BranchesModel
import com.fastaccess.data.dao.FragmentPagerAdapterModel
import com.fastaccess.helper.BundleConstant
import com.fastaccess.helper.Bundler
import com.fastaccess.ui.adapter.FragmentsPagerAdapter
import com.fastaccess.ui.base.BaseDialogFragment
import com.fastaccess.ui.base.mvp.BaseMvp
import com.fastaccess.ui.base.mvp.presenter.BasePresenter
import com.fastaccess.ui.delegate.viewFind
import com.fastaccess.ui.modules.repos.extras.branches.BranchesMvp
import com.google.android.material.tabs.TabLayout

/**
 * Created by kosh on 15/07/2017.
 */
class BranchesPagerFragment : BaseDialogFragment<BaseMvp.FAView, BasePresenter<BaseMvp.FAView>>(),
    BranchesPagerListener {
    val pager: ViewPager by viewFind(R.id.pager)
    val tabs: TabLayout by viewFind(R.id.tabs)
    val toolbar: Toolbar by viewFind(R.id.toolbar)

    private var branchCallback: BranchesMvp.BranchSelectionListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        branchCallback = if (parentFragment is BranchesMvp.BranchSelectionListener) {
            parentFragment as BranchesMvp.BranchSelectionListener
        } else context as BranchesMvp.BranchSelectionListener
    }

    override fun onDetach() {
        branchCallback = null
        super.onDetach()
    }

    override fun onItemSelect(branch: BranchesModel) {
        branchCallback?.onBranchSelected(branch)
        dismiss()
    }

    override fun fragmentLayout(): Int = R.layout.branches_tabbed_viewpager

    override fun providePresenter(): BasePresenter<BaseMvp.FAView> = BasePresenter()

    override fun onFragmentCreated(view: View, savedInstanceState: Bundle?) {
        toolbar.setNavigationIcon(R.drawable.ic_clear)
        toolbar.setNavigationOnClickListener { dismiss() }
        toolbar.setTitle(R.string.switch_branch)
        tabs.setPadding(0, 0, 0, 0)
        tabs.tabMode = TabLayout.MODE_FIXED
        arguments?.let {
            val login = it.getString(BundleConstant.EXTRA)!!
            val repoId = it.getString(BundleConstant.ID)!!
            pager.adapter = FragmentsPagerAdapter(
                childFragmentManager,
                FragmentPagerAdapterModel.buildForBranches(requireContext(), repoId, login)
            )
            tabs.setupWithViewPager(pager)
        }
    }

    companion object {
        fun newInstance(login: String, repoId: String): BranchesPagerFragment {
            val fragment = BranchesPagerFragment()
            fragment.arguments = Bundler.start()
                .put(BundleConstant.ID, repoId)
                .put(BundleConstant.EXTRA, login)
                .end()
            return fragment
        }
    }
}