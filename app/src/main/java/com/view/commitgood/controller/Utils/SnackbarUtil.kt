package com.view.commitgood.controller.Utils

import android.R
import android.app.Activity
import com.google.android.material.snackbar.Snackbar

object SnackbarUtil {
    fun showWarningShortSnackbar(activity: Activity, message: String?) {
        val snackbar = Snackbar.make(
            activity.findViewById(R.id.content),
            message!!,
            4500
        )
        snackbar.view
        snackbar.show()
    }
}