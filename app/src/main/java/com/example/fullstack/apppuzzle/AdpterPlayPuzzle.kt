package com.example.fullstack.apppuzzle

import android.content.ClipData
import android.content.Context
import android.os.Build
import android.support.v7.widget.RecyclerView
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.fullstack.apppuzzle.AdpterPlayPuzzle.ViewHolder
import kotlinx.android.synthetic.main.custom_layout_gameplaypuzzle.view.*

/**
 * Created by FullStack on 9/7/2017.
 */
class AdpterPlayPuzzle(val context: Context, val listHinh: MutableList<Animal>, val resource: Int, val isKiemTra: Boolean, val dragCorrect: DragCorrect) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        return listHinh.size
    }


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val anmal = listHinh.get(position)

        holder?.binData(anmal, isKiemTra, dragCorrect)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {

        val inlayout: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inlayout.inflate(resource, parent, false)
        val viewHolder = ViewHolder(view);
        return viewHolder;
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun binData(animal: Animal, isKiemTra: Boolean, dragCorrect: DragCorrect) {

            if (isKiemTra) {
                // lăng nghe sự kiện
                // holder?.binData(anmal.hinhAn, isKiemTra, dragCorrect)
                itemView.imgPlayPuzzle.setImageResource(animal.hinhAn)
                itemView.imgPlayPuzzle.setTag(animal)
                itemView.imgPlayPuzzle.setOnDragListener { v, event ->
                    val imageDrag: ImageView = event.localState as ImageView
                    when (event.action) {
                        DragEvent.ACTION_DROP -> {
                            if (v.getTag().equals(imageDrag.getTag())) {
                                dragCorrect.Correct(v.getTag() as Animal)
                                v.imgPlayPuzzle.setImageResource(animal.hinhHien)
                            }
                        }

                    }
                    true
                }
            } else {
                // lắng nghe sự kiện keos
                itemView.imgPlayPuzzle.setImageResource(animal.hinhHien)
                itemView.imgPlayPuzzle.setTag(animal)
                itemView.imgPlayPuzzle.setOnLongClickListener { v ->
                    val clipdata = ClipData.newPlainText("", "")
                    val shadow = View.DragShadowBuilder(v)
                    v.startDrag(clipdata, shadow, v, 0)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        v.startDragAndDrop(clipdata, shadow, v, 0)
                    }
                    true
                }
            }

        }

    }
}