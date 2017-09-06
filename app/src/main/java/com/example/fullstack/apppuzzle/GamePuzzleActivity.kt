package com.example.fullstack.apppuzzle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class GamePuzzleActivity : AppCompatActivity() {
var hinhCar= arrayOf(R.drawable.card_concho,R.drawable.card_conchuot,R.drawable.card_conkhi,
        R.drawable.card_conrua,R.drawable.card_consoc,R.drawable.card_convoi,
        R.drawable.card_nguavan, R.drawable.card_tiger )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_puzzle)
    }
}
