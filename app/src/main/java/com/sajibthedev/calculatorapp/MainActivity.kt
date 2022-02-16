package com.sajibthedev.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import com.sajibthedev.calculatorapp.databinding.ActivityMainBinding
import java.lang.StringBuilder
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var check = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.inputex.movementMethod = ScrollingMovementMethod()
        binding.inputex.isActivated
        binding.inputex.isPressed

        var text: String

        // =============== Button 1  ================
        binding.button1.setOnClickListener {
            text = binding.inputex.text.toString() + "1"
            binding.inputex.setText(text)
            result(text)
        }

        // =============== Button 2  ================
        binding.button2.setOnClickListener {
            text = binding.inputex.text.toString() + "2"
            binding.inputex.setText(text)
            result(text)
        }

        // =============== Button 3  ================
        binding.button3.setOnClickListener {
            text = binding.inputex.text.toString() + "3"
            binding.inputex.setText(text)
            result(text)
        }

        // =============== Button 4  ================
        binding.button4.setOnClickListener {
            text = binding.inputex.text.toString() + "4"
            binding.inputex.setText(text)
            result(text)
        }

        // =============== Button 5  ================

        binding.button5.setOnClickListener {
            text = binding.inputex.text.toString() + "5"
            binding.inputex.setText(text)
            result(text)
        }

        // =============== Button 6  ================

        binding.button6.setOnClickListener {
            text = binding.inputex.text.toString() + "6"
            binding.inputex.setText(text)
            result(text)
        }

        // =============== Button 7  ================
        binding.button7.setOnClickListener {
            text = binding.inputex.text.toString() + "7"
            binding.inputex.setText(text)
            result(text)
        }

        // =============== Button 8  ================
        binding.button8.setOnClickListener {
            text = binding.inputex.text.toString() + "8"
            binding.inputex.setText(text)
            result(text)
        }

        // =============== Button 9  ================
        binding.button9.setOnClickListener {
            text = binding.inputex.text.toString() + "9"
            binding.inputex.setText(text)
            result(text)
        }

// =============== Button 0  ================
        binding.button0.setOnClickListener {
            text = binding.inputex.text.toString() + "0"
            binding.inputex.setText(text)
            result(text)
        }

        // =============== Button 00  ================
        binding.button00.setOnClickListener {
            text = binding.inputex.text.toString() + "00"
            binding.inputex.setText(text)
            result(text)
        }

        // =============== Button dot  ================
        binding.buttondot.setOnClickListener {
            text = binding.inputex.text.toString() + "."
            binding.inputex.setText(text)
            result(text)
        }


        // =============== Button Add  ================

        binding.buttonadd.setOnClickListener {
            text = binding.inputex.text.toString() + "+"
            binding.inputex.setText(text)
            check += 1
        }

        // =============== Button Sub  ================
        binding.buttonminus.setOnClickListener {
            text = binding.inputex.text.toString() + "-"
            binding.inputex.setText(text)
            check += 1
        }

        // =============== Button Multiply  ================
        binding.buttonmultiply.setOnClickListener {
            text = binding.inputex.text.toString() + "*"
            binding.inputex.setText(text)
            check += 1
        }

        // =============== Button Divide  ================

        binding.buttondivide.setOnClickListener {
            text = binding.inputex.text.toString() + "/"
            binding.inputex.setText(text)
            check += 1
        }

        binding.buttonpercent.setOnClickListener {
            text = binding.inputex.text.toString() + "%"
            binding.inputex.setText(text)
            check += 1
        }

        binding.buttonequal.setOnClickListener {
            text = binding.resulttex.text.toString()
            binding.inputex.setText(text)
            binding.resulttex.text = null

        }

        binding.clear.setOnClickListener {
            binding.inputex.setText(null)
            binding.resulttex.text = null
        }

        binding.buttonbackspace.setOnClickListener {
            var BackSpace: String? = null
            if (binding.inputex.text.length > 0) {
                val stringBuilder: StringBuilder = StringBuilder(binding.inputex.text)
                val find = binding.inputex.text.toString()
                val find2 = find.last()

                if (find2.equals('+') || find2.equals('-') || find2.equals('*') || find2.equals('/') || find2.equals(
                        '%'
                    )
                ) {
                    check += 1
                }

                stringBuilder.deleteCharAt(binding.inputex.text.length - 1)
                BackSpace = stringBuilder.toString()
                binding.inputex.setText(BackSpace)
                result(BackSpace)
            }
        }

    }

    private fun result(text: String) {
        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try {
            val result:Any = engine.eval(text)
            var mainr = result.toString()
            if (check == 0){
                binding.resulttex.setText(null)
            }else{
                binding.resulttex.setText(mainr)
            }
        }
        catch (e: ScriptException){}
        Log.d("TAG", "Error")
    }
}