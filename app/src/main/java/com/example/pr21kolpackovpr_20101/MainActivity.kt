package com.example.pr21kolpackovpr_20101

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //основной блок цифр
        nine_btn.setOnClickListener{setTextFields("9")}
        eight_btn.setOnClickListener{setTextFields("8")}
        seven_btn.setOnClickListener{setTextFields("7")}
        six_btn.setOnClickListener{setTextFields("6")}
        five_btn.setOnClickListener{setTextFields("5")}
        four_btn.setOnClickListener{setTextFields("4")}
        three_btn.setOnClickListener{setTextFields("3")}
        two_btn.setOnClickListener{setTextFields("2")}
        one_btn.setOnClickListener{setTextFields("1")}
        zero_btn.setOnClickListener{setTextFields("0")}


        //симфолы операций
        minus_btn.setOnClickListener{setTextFields("-")}
        plus_btn.setOnClickListener{setTextFields("+")}
        star_btn.setOnClickListener{setTextFields("*")}
        slesh_btn.setOnClickListener{setTextFields("/")}
        bracket_l_btn.setOnClickListener{setTextFields("(")}
        bracket_r_btn.setOnClickListener{setTextFields(")")}

        //кнопки отсичтки
        clear_btn.setOnClickListener{
            math_operation.text =""
            result_text.text =""
        }
        deleteonesimv_btn.setOnClickListener {
            val str = math_operation.text.toString()
            if(str.isNotEmpty())
            {
                math_operation.text = str.substring(0, str.length - 1)
            }
            result_text.text=""
        }

        round_btn.setOnClickListener {
            try{

                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val  result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()
            }   catch (e:Exception){
                Log.d("Ошибка", "Сообщение: ${e.message}")
            }
        }
    }

    fun setTextFields (str: String) {
        if(result_text.text !=""){
            math_operation.text =result_text.text
            result_text.text = ""
        }

        math_operation.append(str)
    }
}

