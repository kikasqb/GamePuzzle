package com.example.fullstack.apppuzzle

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.custom_layout_choise.view.*

/**
 * Created by FullStack on 9/5/2017.
 */
class AdapterViewHolder(val context: Context, val listHinh: Array<Int>, val resource: Int) : RecyclerView.Adapter<AdapterViewHolder.ViewHolder>() {

    override fun onBindViewHolder(holder: AdapterViewHolder.ViewHolder?, position: Int) {
        holder?.binData(listHinh[position], context)
    }

    override fun getItemCount(): Int {
        return listHinh.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inlayout: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inlayout.inflate(resource, parent, false)
        val viewHolder: ViewHolder = ViewHolder(view)
        return viewHolder
    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun binData(resourceHinh: Int, context: Context) {
            itemView.imagePictuer.setImageResource(resourceHinh)
            itemView.imagePictuer.setOnClickListener { v ->
                val intent = Intent(context, PlayGamePuzzleActivity::class.java)
                context.startActivity(intent)
            }

        }
//        val image: ImageButton = itemview.imagePictuer
    }

}