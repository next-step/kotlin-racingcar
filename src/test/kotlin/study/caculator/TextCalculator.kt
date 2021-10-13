package study.caculator

import study.caculator.data.TextReader
import study.caculator.mathcalculator.DivideCalculator
import study.caculator.mathcalculator.MinusCalculator
import study.caculator.mathcalculator.MultiplyCalculator
import study.caculator.mathcalculator.PlusCalculator

class TextCalculator(text: String?) {
    private var result = 0
    private val calculators = mapOf(
        "+" to PlusCalculator(), "-" to MinusCalculator(),
        "*" to MultiplyCalculator(), "/" to DivideCalculator()
    )

    init {
        val parsedText = TextReader(text).getTexts()
        calculate(parsedText)
    }

    private fun calculate(parsedText: List<String>) {
        result = startNumber(parsedText)
        for (i in parsedText.indices) {
            calculateWithMatchedOperator(i, parsedText)
        }
    }

    private fun calculateWithMatchedOperator(i: Int, parsedText: List<String>) {
        val calculator = calculators[parsedText[i]]

        if (calculator != null) {
            result = calculator.calculate(result, parsedText[i + 1].toInt())
        }
    }

    private fun startNumber(parsedText: List<String>) = parsedText[0].toInt()

    fun result(): Int {
        return result
    }
}
