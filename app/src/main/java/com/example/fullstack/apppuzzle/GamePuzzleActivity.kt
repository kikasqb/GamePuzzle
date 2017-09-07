package com.example.fullstack.apppuzzle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_game_puzzle.*

class GamePuzzleActivity : AppCompatActivity() {
var hinhCar= arrayOf(R.drawable.card_concho,R.drawable.card_conchuot,R.drawable.card_conkhi,
        R.drawable.card_conrua,R.drawable.card_consoc,R.drawable.card_convoi,
        R.drawable.card_nguavan, R.drawable.card_tiger )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_puzzle)
        val adapter = AdapterViewHolder(this,hinhCar,R.layout.custom_layout_choise);
        val layoutmanager = GridLayoutManager(this,4)
        recyclerViewChoise.layoutManager = layoutmanager
        recyclerViewChoise.adapter = adapter;
        adapter.notifyDataSetChanged()
    }
}
