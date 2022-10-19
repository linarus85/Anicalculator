package com.example.anicalculator

import android.content.Context
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_clear.setOnClickListener {
            tv_input.text = ""
            tv_outinput.text = ""
            vibratePhone()
        }
        btn_bracket_left.setOnClickListener {
            tv_input.text = addInputText("(")
            vibratePhone()
        }
        btn_bracket_right.setOnClickListener {
            tv_input.text = addInputText(")")
            vibratePhone()
        }
        btn_null.setOnClickListener {
            tv_input.text = addInputText("0")
            vibratePhone()
        }
        btn_bracket_left.setOnClickListener {
            tv_input.text = addInputText("(")
            vibratePhone()
        }
        btn_1.setOnClickListener {
            tv_input.text = addInputText("1")
            vibratePhone()
        }
        btn_2.setOnClickListener {
            tv_input.text = addInputText("2")
            vibratePhone()
        }
        btn_3.setOnClickListener {
            tv_input.text = addInputText("3")
            vibratePhone()
        }
        btn_4.setOnClickListener {
            tv_input.text = addInputText("4")
            vibratePhone()
        }
        btn_5.setOnClickListener {
            tv_input.text = addInputText("5")
            vibratePhone()
        }
        btn_6.setOnClickListener {
            tv_input.text = addInputText("6")
            vibratePhone()
        }
        btn_7.setOnClickListener {
            tv_input.text = addInputText("7")
            vibratePhone()
        }
        btn_8.setOnClickListener {
            tv_input.text = addInputText("8")
            vibratePhone()
        }
        btn_9.setOnClickListener {
            tv_input.text = addInputText("9")
            vibratePhone()
        }
        btn_point.setOnClickListener {
            tv_input.text = addInputText(".")
            vibratePhone()
        }
        btn_division.setOnClickListener {
            tv_input.text = addInputText("÷")
            vibratePhone()
        }
        btn_x.setOnClickListener {
            tv_input.text = addInputText("×")
            vibratePhone()
        }
        btn_plus.setOnClickListener {
            tv_input.text = addInputText("+")
            vibratePhone()
        }
        btn_minus.setOnClickListener {
            tv_input.text = addInputText("-")
            vibratePhone()
        }
        btn_equal.setOnClickListener {
            showResult()
            vibratePhone()
        }
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                tv_outinput.text = "Error"
                tv_outinput.setTextColor(ContextCompat.getColor(this,R.color.red))
            } else {
                tv_outinput.text = DecimalFormat("0.######")
                    .format(result).toString()
                tv_outinput.setTextColor(ContextCompat.getColor(this,R.color.green))

            }
        } catch (e: Exception) {
            tv_outinput.text = "Error"
            tv_outinput.setTextColor(ContextCompat.getColor(this,R.color.red))
        }
    }

    private fun getInputExpression(): String {
        var expression = tv_input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun addInputText(btnValue: String): String {
        return "${tv_input.text}$btnValue"
    }
    fun vibratePhone() {
        val vib = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager =
                getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator
        } else {
            @Suppress("DEPRECATION")
            getSystemService(VIBRATOR_SERVICE) as Vibrator
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vib.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE) )
        }else{
            @Suppress("DEPRECATION")
            vib.vibrate(50)
        }
    }

}