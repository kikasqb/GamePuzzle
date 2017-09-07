package com.example.fullstack.apppuzzle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.layout_play_game_puzzle.*

class PlayGamePuzzleActivity : AppCompatActivity(), DragCorrect {


    val hinhHien = arrayOf(R.drawable.concho_01,
            R.drawable.concho_02,
            R.drawable.concho_03,
            R.drawable.concho_04,
            R.drawable.concho_05,
            R.drawable.concho_06,
            R.drawable.concho_07,
            R.drawable.concho_08,
            R.drawable.concho_09)
    val hinhAn = arrayOf(R.drawable.conchoan_01,
            R.drawable.conchoan_02,
            R.drawable.conchoan_03,
            R.drawable.conchoan_04,
            R.drawable.conchoan_05,
            R.drawable.conchoan_06,
            R.drawable.conchoan_07,
            R.drawable.conchoan_08,
            R.drawable.conchoan_09)
    val listAnnmal = mutableListOf<Animal>()
    var adapterHinhHien: AdpterPlayPuzzle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_play_game_puzzle)
        for (cout in 0..hinhHien.size - 1) {
            val animal = Animal(hinhHien[cout], hinhAn[cout])
            listAnnmal.add(animal)
        }
        adapterHinhHien = AdpterPlayPuzzle(this, listAnnmal, R.layout.custom_layout_gameplaypuzzle, false, this)
        val layoutmanager = LinearLayoutManager(this)
        recyclerViewList.layoutManager = layoutmanager
        recyclerViewList.adapter = adapterHinhHien
        adapterHinhHien?.notifyDataSetChanged()
        val adapterHinhAn = AdpterPlayPuzzle(this, listAnnmal, R.layout.custom_layout_gameplaypuzzle, true, this)
        val layoutmagagerHinhAn = GridLayoutManager(this, 3)
        recyclerViewAn.layoutManager = layoutmagagerHinhAn
        recyclerViewAn.adapter = adapterHinhAn
        adapterHinhAn.notifyDataSetChanged()

    }

    override fun Correct(animal: Animal) {
        listAnnmal.remove(animal)
        adapterHinhHien?.notifyDataSetChanged()

    }
}
