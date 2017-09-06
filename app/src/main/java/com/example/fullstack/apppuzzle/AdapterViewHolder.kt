package com.example.fullstack.apppuzzle

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

/**
 * Created by FullStack on 9/5/2017.
 */
class  AdapterViewHolder(val listHinh:Array<Int>, val resource: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

// code tạo dạo diện màn hình
    override fun onCreateViewHolder(parent: ViewGroup?, position: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
       return listHinh.size;
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){

    }

}