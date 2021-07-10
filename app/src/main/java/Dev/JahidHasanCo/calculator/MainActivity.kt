package Dev.JahidHasanCo.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

    button_clear.setOnClickListener {
        input.text = ""
        output.text = ""
    }

        button_bracket.setOnClickListener {

                input.text = addToInputText("(")

    }
        button_bracket_r.setOnClickListener {

                input.text = addToInputText(")")

    }

        button_croxx.setOnClickListener {
           val removedLast = input.text.toString().dropLast(1)
            input.text = removedLast
        }

    button_0.setOnClickListener {
        input.text = addToInputText("0")
    }
    button_1.setOnClickListener {
        input.text = addToInputText("1")
    }
    button_2.setOnClickListener {
        input.text = addToInputText("2")
    }
    button_3.setOnClickListener {
        input.text = addToInputText("3")
    }
    button_4.setOnClickListener {
        input.text = addToInputText("4")
    }
    button_5.setOnClickListener {
        input.text = addToInputText("5")
    }
    button_6.setOnClickListener {
        input.text = addToInputText("6")
    }
    button_7.setOnClickListener {
        input.text = addToInputText("7")
    }
    button_8.setOnClickListener {
        input.text = addToInputText("8")
    }
    button_9.setOnClickListener {
        input.text = addToInputText("9")
    }
    button_dot.setOnClickListener {
        input.text = addToInputText(".")
    }
    button_division.setOnClickListener {
        input.text = addToInputText("÷") // ALT + 0247
    }
    button_multiply.setOnClickListener {
        input.text = addToInputText("×") // ALT + 0215
    }

    button_subtraction.setOnClickListener {
        input.text = addToInputText("-")
    }
    button_addition.setOnClickListener {
        input.text = addToInputText("+")
    }

    button_equals.setOnClickListener {
        showResult()
    }
}

private fun addToInputText(buttonValue: String): String {

    return input.text.toString() + "" + buttonValue
}

private fun getInputExpression(): String {
    var expression = input.text.replace(Regex("÷"), "/")
    expression = expression.replace(Regex("×"), "*")
    return expression
}

private fun showResult() {
    try {
        val expression = getInputExpression()
        val result = Expression(expression).calculate()
        if (result.isNaN()) {
            // Show Error Message
            output.text = ""
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        } else {
            // Show Result
            output.text = DecimalFormat("0.######").format(result).toString()
            output.setTextColor(ContextCompat.getColor(this, R.color.green))
        }
    } catch (e: Exception) {
        // Show Error Message
        output.text = ""
        output.setTextColor(ContextCompat.getColor(this, R.color.red))
    }
}
}