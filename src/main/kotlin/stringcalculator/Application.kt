package stringcalculator

import stringcalculator.domain.Operator
import stringcalculator.ui.InputView

fun main() {
    Application().run()
}

private const val INDEX_OF_NUMBER = 0
private const val INDEX_OF_SIGN = 1

class Application {

    fun run() {
        val inputFormula = InputView().inputFormula()
        val result = calculate(inputFormula)
        print(result)
    }

    private fun calculate(inputFormula: List<String>): Int {
        val numbers = getNumbers(inputFormula)
        val signs = getSigns(inputFormula)

        return calculateInternal(numbers, signs)
    }

    private fun calculateInternal(numbers: List<Int>, signs: List<String>): Int {
        var summary = numbers[0]
        for (i in signs.indices) {
            val operator = Operator.of(signs[i])

            val left = summary
            val right = numbers[i + 1]
            summary = operator.calculate(left, right)
        }

        return summary
    }

    private fun getSigns(stringFormula: List<String>) =
        stringFormula.filterIndexed { index, _ -> index % 2 == INDEX_OF_SIGN }.map { it }

    private fun getNumbers(stringFormula: List<String>) =
        stringFormula.filterIndexed { index, _ -> index % 2 == INDEX_OF_NUMBER }.map { it.toInt() }
}
