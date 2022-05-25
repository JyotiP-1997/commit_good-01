package com.view.commitgood.view.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.view.commitgood.R
import com.view.commitgood.controller.Utils.SnackbarUtil
import com.view.commitgood.controller.Utils.Validations
import com.view.commitgood.model.LoginResponse
import com.view.commitgood.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener{
    private  var viewModel: LoginViewModel?=null
        var loggedIn: String?= null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        InitView()
    }

    private fun InitView()
    {
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        btn_login.setOnClickListener(this)
    }

    override fun onClick(v: View?)    {

        when(v?.id){

            R.id.btn_login -> {

                if(Validations.isValidateLogin(this,et_email,et_pwd))
                {
                    doLogin()
                }
            }
        }
    }
            ////////*********************Login API******************\\\\\\\\\\\\\\\\\\\\\\\\\

    private fun doLogin() {
        clLoader_login.visibility = View.VISIBLE
        viewModel?.login(et_email.text.toString().trim(),et_pwd.text.toString().trim())?.observe(
            this,
            object : Observer<LoginResponse>
            {
                override fun onChanged(@Nullable loginResponse: LoginResponse?)
                {
                    clLoader_login.visibility = View.GONE
                    loggedIn = loginResponse?.loggedIn.toString()
                    // Log.e("mes",loginResponse?.accessToken+"")

                    if (loggedIn.equals("true"))
                    {

                        val intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intent)
                        finishAffinity()
                    } else
                    {

                        showSnackBar("invalid login details")
                    }
                }
            })
    }

    private fun showSnackBar(message: String?) {
        SnackbarUtil.showWarningShortSnackbar(this,message)
    }










    //................................hide keyboard on touch.................................................
    fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager =
            activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE
            ) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            activity.currentFocus!!.windowToken, 0
        )
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        val view = currentFocus
        val ret = super.dispatchTouchEvent(ev)
        if (view is EditText) {
            val w = currentFocus
            val scrcoords = IntArray(2)
            w!!.getLocationOnScreen(scrcoords)
            val x = ev.rawX + w.left - scrcoords[0]
            val y = ev.rawY + w.top - scrcoords[1]
            if (ev.action == MotionEvent.ACTION_UP
                && (x < w.left || x >= w.right || y < w.top || y > w.bottom)
            ) {
                hideSoftKeyboard(this)
            }
        }
        return ret
    }
}


