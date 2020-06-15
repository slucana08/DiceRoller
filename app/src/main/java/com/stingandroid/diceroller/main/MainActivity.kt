package com.stingandroid.diceroller.main

import android.os.Bundle
import com.stingandroid.diceroller.R
import com.stingandroid.diceroller.core.BaseActivity
import com.stingandroid.diceroller.databinding.ActivityMainBinding
import com.stingandroid.diceroller.main.models.Luck
import kotlin.random.Random

class MainActivity : BaseActivity<ActivityMainBinding>(MainActivityActions) {

    private val list = mutableListOf<Luck>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startLuckList()
        setUpRollButton()
    }

    private fun startLuckList(){
        list.apply {
            add(Luck(0,getString(R.string.hello_android)))
            add(Luck(1,"It is ok"))
            add(Luck(2,"Still meh"))
            add(Luck(3,"It is good!"))
            add(Luck(4,"Decent!"))
            add(Luck(5,"Close call!"))
            add(Luck(6,"Lucky one!"))
        }
    }

    private fun setUpRollButton() {
        binding?.apply{
            luck = list[0]
            rollBtn.setOnClickListener { rollDice() }
        }
    }

    private fun rollDice() {
        val value = Random.nextInt(6) + 1
        binding?.apply {
            diceIv.setImageResource(
                when (value) {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    else -> R.drawable.dice_6
                }
            )
            luck = list[value]
        }
    }


}



