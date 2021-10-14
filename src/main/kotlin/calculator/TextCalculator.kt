package calculator

import calculator.data.TextReader
import calculator.mathcalculator.DivideCalculator
import calculator.mathcalculator.MinusCalculator
import calculator.mathcalculator.MultiplyCalculator
import calculator.mathcalculator.PlusCalculator

class TextCalculator {
    private val calculators = mapOf(
        "+" to PlusCalculator(), "-" to MinusCalculator(),
        "*" to MultiplyCalculator(), "/" to DivideCalculator()
    )

    fun calculate(text: String?): Int {
        val parsedText = TextReader().parseText(text)
        var result = startNumber(parsedText)
        for (i in parsedText.indices) {
            result = calculateWithMatchedOperator(i, result, parsedText)
        }
        return result
    }

    private fun calculateWithMatchedOperator(i: Int, result: Int, parsedText: List<String>): Int {
        val calculator = calculators[parsedText[i]]
        if (calculator != null) {
            val nextNumber = parsedText[i + 1].toInt()
            return calculator.calculate(result, nextNumber)
        }
        return result
    }

    private fun startNumber(parsedText: List<String>) = parsedText[0].toInt()
}
