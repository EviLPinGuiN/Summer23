package com.itis.summerpractie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var clickButton: Button? = null

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("ARG_COUNT")
        }

        var text2 = "asdasd"

        text2 = "new value"


        val textView = findViewById<TextView>(R.id.textView)
        clickButton = findViewById<Button>(R.id.button)
        clickButton?.setOnClickListener {
            count++
            textView.text = "Our counter: $count"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("ARG_COUNT", count)
    }


    fun myNameFun(arg1: String, arg2: Int = 0): String {
        "ANDOIRD: ${arg1.length}, $arg2"
        return arg1 + arg2
    }

    fun whenTest(color: String, isTest: Boolean): String = when {
        isTest && color.length > 10 -> "Green"
        color.length > 5 -> {
            myNameFun("Test")
            "Red"
        }
        color == "yellow" -> "Yellow"
        else -> "BLACK"
    }

}

interface Test {
    fun move()
}

class Student(
    name: String,
    age: Int = 18,
) : User(name, age), Test {

    override fun move() {
        TODO("Not yet implemented")
    }

    override val email: String
        get() = "Student"

}

abstract class User(
    val name: String,
    val age: Int,
) {

    abstract val email: String
}