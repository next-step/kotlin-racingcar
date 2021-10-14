package calculator

import calculator.data.TextReader
import calculator.mathcalculator.DivideCalculator
import calculator.mathcalculator.MinusCalculator
import calculator.mathcalculator.MultiplyCalculator
import calculator.mathcalculator.PlusCalculator

class TextCalculator {
    private var result = 0
    private val calculators = mapOf(
        "+" to PlusCalculator(), "-" to MinusCalculator(),
        "*" to MultiplyCalculator(), "/" to DivideCalculator()
    )

    fun calculate(text: String?): Int {
        val parsedText = TextReader().parseText(text)

        result = startNumber(parsedText)
        for (i in parsedText.indices) {
            calculateWithMatchedOperator(i, parsedText)
        }
        return result
    }

    private fun calculateWithMatchedOperator(i: Int, parsedText: List<String>) {
        val calculator = calculators[parsedText[i]]

        if (calculator != null) {
            result = calculator.calculate(result, parsedText[i + 1].toInt())
        }
    }

    private fun startNumber(parsedText: List<String>) = parsedText[0].toInt()
}
