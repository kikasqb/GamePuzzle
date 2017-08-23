package com.example.fullstack.apppuzzle

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imgGameAnimal.setOnClickListener(this)
        imgAnimalPuzzle.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.nhacnentrangchu);
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.stop()
    }
// chuyển bage trong kotlin
    override fun onClick(v: View?) {
        when (v) {
            imgAnimalPuzzle -> {
               startActivity(this,GamePuzzleActivity::class.java)
            }
            imgGameAnimal -> {
                startActivity(this,GameAnimalActivity::class.java)
            }
        }
    }
    // tao fun hàm satractivity trong  kotlin
    fun  Context.startActivity(form: Context, to:Class<*>){
        val intent: Intent = Intent(form, to)
        startActivity(intent)
    }


}
