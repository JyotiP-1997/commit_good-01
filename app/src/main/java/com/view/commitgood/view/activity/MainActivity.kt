package com.view.commitgood.view.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import androidx.annotation.Nullable
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.view.commitgood.R
import com.view.commitgood.controller.Utils.App
import com.view.commitgood.controller.Utils.AppPreferences
import com.view.commitgood.controller.Utils.Constants
import com.view.commitgood.model.DataItems
import com.view.commitgood.view.adapter.Cureent_Adapter
import com.view.commitgood.viewmodel.HomeViewModel

import kotlinx.android.synthetic.main.activity_completed.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.side_bar_nav_menu.*

class MainActivity : AppCompatActivity(),DrawerLayout.DrawerListener, View.OnClickListener
{

    private var Cureent_Adapter: Cureent_Adapter? = null
    private var home_list: ArrayList<DataItems> = ArrayList()
    internal var rootView: View? = null
    var mUser_id: String? = null
    private var viewModel: HomeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView()
    {

        mUser_id = AppPreferences.init(App.getAppContext()).getString(Constants.USER_ID)
        Log.d("userid", mUser_id + "")
        btn_nav_menu.setOnClickListener(this)

        tv_current.setOnClickListener(this)

        tv_complete.setOnClickListener(this)
        ll_good.setOnClickListener(this)
        tv_logout.setOnClickListener(this)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        getHomeApi()

    }

    private fun getHomeApi()
    {
      //  clLoader_main.visibility = View.VISIBLE
        viewModel?.getHome(mUser_id.toString())?.observe(
            this,
            object : Observer<List<DataItems>>
            {
                override fun onChanged(@Nullable homeResponse: List<DataItems>?)  {

               //     clLoader_main.visibility = View.GONE
                    home_list = homeResponse as ArrayList<DataItems>
                    rv_home?.layoutManager = LinearLayoutManager(this@MainActivity,
                        LinearLayoutManager.VERTICAL, false)
                    rv_home?.adapter = Cureent_Adapter(this@MainActivity, home_list)
                    (rv_home?.adapter as Cureent_Adapter).onItemClick = { pos, view ->

                        var mCompaingId = home_list?.get(pos).id
                        Log.d("userid", mCompaingId.toString() + "")
                        val intent = Intent(this@MainActivity, DetailActivity::class.java)
                        intent.putExtra("compaingid", mCompaingId.toString())
                        startActivity(intent)



                    }
                    rv_home?.setNestedScrollingEnabled(false)

                }
            })
    }

    //************************-- Side Bar Navigation Menu ******************************\\

    override fun onDrawerSlide(drawerView: View, slideOffset: Float)
    {

    }

    override fun onDrawerOpened(drawerView: View)
    {

    }

    override fun onDrawerClosed(drawerView: View)
    {

    }

    override fun onDrawerStateChanged(newState: Int)
    {

    }

    //****************** OnClick to Nav. Drawer ******************\\
    @SuppressLint("WrongConstant")
    override fun onClick(v: View?)
    {

        when (v?.id)
        {

            R.id.btn_nav_menu ->
            {
                drawer_lyt.openDrawer(Gravity.START)
            }
            R.id.tv_current ->
            {

                drawer_lyt.closeDrawer(Gravity.START, false)
            }
            R.id.tv_complete ->
            {
                val intent = Intent(this, CompletedActivity::class.java)
                startActivity(intent)
            }
            R.id.ll_good ->
            {
                val intent = Intent(this, Good_Esc_Activity::class.java)
                startActivity(intent)
            }
            R.id.tv_logout ->
            {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finishAffinity()
            }
        }
    }
}
