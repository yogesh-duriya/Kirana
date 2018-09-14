package com.kirana.ui.main.orders.viewReceipt.view

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kirana.R
import com.kirana.ui.base.view.BaseDialogView
import com.kirana.ui.main.orders.viewReceipt.interactor.ViewReceiptMVPInterator
import com.kirana.ui.main.orders.viewReceipt.presenter.ViewReceiptMVPPresenter
import kotlinx.android.synthetic.main.dialogue_view_receipt.*
import javax.inject.Inject

class ViewReceiptDialog : BaseDialogView(), ViewRecieptDialogMVPView {

    companion object {
        fun newInstance(): ViewReceiptDialog? {
            return ViewReceiptDialog()
        }

    }

    @Inject
    internal lateinit var presenter: ViewReceiptMVPPresenter<ViewRecieptDialogMVPView, ViewReceiptMVPInterator>

    private val TAG = "ViewReceiptDialog"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.dialogue_view_receipt, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this)
        tv_close.setOnClickListener { presenter.onLaterOptionClicked() }
        //btnSubmit.setOnClickListener { presenter.onSubmitOptionClicked() }
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }

    override fun dismissDialog() = super.dismissDialog(TAG)

    override fun showRatingSubmissionSuccessMessage() = Toast.makeText(context, "Submitted successfully", Toast.LENGTH_LONG).show()

    internal fun show(fragmentManager: FragmentManager) = super.show(fragmentManager, TAG)

    override fun showToast(message: String?) {

    }
}