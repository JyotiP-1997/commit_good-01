package com.view.commitgood.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.view.commitgood.R
import com.view.commitgood.model.DataItems
import com.view.commitgood.view.activity.MainActivity
import com.view.commitgood.view.adapter.Cureent_Adapter.*
import kotlinx.android.synthetic.main.list_items.view.*

class Cureent_Adapter(val activity: MainActivity, current_list: ArrayList<DataItems>) :
    RecyclerView.Adapter<Cureent_Adapter.MyViewHolder>()
{
    var image: String? = null
    private var current_list: ArrayList<DataItems>? = current_list

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        val itemsView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_items, parent, false)
        return MyViewHolder(itemsView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        Log.e("nameee", current_list?.get(position)?.name + "")
        holder.itemView.tv_name.text = current_list?.get(position)?.name
        holder.itemView.tv_des.text = current_list?.get(position)?.name
        image = current_list?.get(position)?.image
        if (image !== null)
        {

            activity?.let {
                Glide.with(it)
                    .load(image)
                    .into(holder.itemView.img_lst_item)
            }
        } else
        {
            holder.itemView.img_lst_item.setImageResource(R.drawable.new1)
        }
    }

    override fun getItemCount(): Int {
        return current_list!!.size
    }

   inner class MyViewHolder(itemsView: View): RecyclerView.ViewHolder(itemsView), View.OnClickListener   {
        override fun onClick(v: View?) {

            onItemClick?.invoke(adapterPosition, v!!)
        }
            init   {
                itemsView.setOnClickListener(this)

            }

    }

}