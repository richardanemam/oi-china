package com.example.richard.oichina.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ErrorDialogFragment : DialogFragment() {

    companion object {
        const val TITLE = "title"
        const val ERRORS_MESSAGE = "errorMessage"
        const val TRY_AGAIN = "tryAgain"
        const val DEFAULT_VALUE = "algo esta errado, sorry!"
    }

    private lateinit var title: String
    private lateinit var message: String
    private lateinit var tryAgain: String
    private lateinit var listener: ErrorDialogListener

    interface ErrorDialogListener {
        fun onDialogPositiveClick(dialog: DialogFragment)
    }

    fun newInstance(title: String, message: String, tryAgainButton: String): ErrorDialogFragment {
        val errorDialog = ErrorDialogFragment()
        val args = Bundle()
        args.putString(TITLE, title)
        args.putString(ERRORS_MESSAGE, message)
        args.putString(TRY_AGAIN, tryAgainButton)
        errorDialog.arguments = args
        return errorDialog
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        title = arguments!!.getString(TITLE, DEFAULT_VALUE)
        message = arguments!!.getString(ERRORS_MESSAGE, DEFAULT_VALUE)
        tryAgain = arguments!!.getString(TRY_AGAIN, DEFAULT_VALUE)

        val builder = AlertDialog.Builder(activity)
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(tryAgain) { dialog, id ->
                    listener.onDialogPositiveClick(this@ErrorDialogFragment)
                }
        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            // Instantiate the ErrorDialogListener so we can send events to the host
            listener = context as ErrorDialogListener
        } catch (e: ClassCastException) {
            // The activity doesn't implement the interface, throw exception
            throw ClassCastException("$activity must implement ErrorDialogListener")
        }
    }
}