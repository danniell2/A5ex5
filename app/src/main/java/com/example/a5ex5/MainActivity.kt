package com.example.a5ex5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random
import android.util.Log


class MainActivity : AppCompatActivity() {
    var score: Int = 0
    lateinit var txtScore: TextView
    lateinit var txtRes: TextView
    lateinit var btnNewGame: Button
    lateinit var btnPar: Button
    lateinit var btnImpar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtRes = findViewById(R.id.txtRes)
        btnNewGame = findViewById(R.id.btnNewGame)
        btnPar =  findViewById(R.id.btnPar)
        btnImpar = findViewById(R.id.btnImpar)
        txtScore = findViewById(R.id.txtScore)
        btnPar.visibility = View.INVISIBLE
        btnImpar.visibility = View.INVISIBLE
        txtScore.visibility = View.INVISIBLE
        btnNewGame.setOnClickListener { newGame() }
    }

    fun newGame(){
        txtRes.text = Random.nextInt(0,100).toString()
        btnNewGame.visibility = View.INVISIBLE
        btnPar.visibility = View.VISIBLE
        btnImpar.visibility = View.VISIBLE
        txtScore.visibility = View.VISIBLE
        score = 0
        txtScore.text = score.toString()

        btnPar.setOnClickListener { Par(txtRes.text.toString().toInt()) }
        btnImpar.setOnClickListener { Impar(txtRes.text.toString().toInt()) }
    }

    fun Par(numero: Int){
        if(numero % 2 == 0){
            score++
            txtScore.text = score.toString()
            Log.d("score", "par")
            txtRes.text = Random.nextInt(0,100).toString()
            btnNewGame.visibility = View.VISIBLE
        }
    }

    fun Impar(numero: Int){
        if(numero % 2 != 0){
            score++
            txtScore.text = score.toString()
            Log.d("score", "impar")
            txtRes.text = Random.nextInt(0,100).toString()
            btnNewGame.visibility = View.VISIBLE
        }
    }
}
