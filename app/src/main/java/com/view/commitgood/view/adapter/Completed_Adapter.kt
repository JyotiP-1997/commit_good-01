package com.view.commitgood.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.view.commitgood.R
import com.view.commitgood.model.DataItemCom
import com.view.commitgood.model.DataItems
import com.view.commitgood.view.activity.CompletedActivity
import kotlinx.android.synthetic.main.comp_list_items.view.*
import kotlinx.android.synthetic.main.list_items.view.*

class Completed_Adapter(val activity: CompletedActivity, completed_list: ArrayList<DataItemCom>) :
    RecyclerView.Adapter<Completed_Adapter.MyViewHolder>()
{

    var image: String? = null
    private var completed_list: ArrayList<DataItemCom>? = completed_list

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemsView =LayoutInflater.from(parent.context).inflate(R.layout.comp_list_items, parent, false)
        return MyViewHolder(itemsView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        Log.e("nameee", completed_list?.get(position)?.name + "")
        holder.itemView.tv_name_com.text = completed_list?.get(position)?.name
        holder.itemView.tv_des_com.text = completed_list?.get(position)?.name
        image = completed_list?.get(position)?.image
        if (image !== null)
        {

            activity?.let {
                Glide.with(it)
                    .load(image)
                    .into(holder.itemView.img_lst_item_com)
            }
        } else
        {
            holder.itemView.img_lst_item_com.setImageResource(R.drawable.new1)
        }

    }

    override fun getItemCount(): Int
    {
        return completed_list!!.size
    }

    inner class MyViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView),
        View.OnClickListener
    {
        override fun onClick(v: View?)
        {
            onItemClick?.invoke(adapterPosition, v!!)
        }

        init
        {
            itemsView.setOnClickListener(this)

        }
    }

}
