package stringArithmeticCalculator

import java.util.regex.Pattern

class Calculator(private val input: String) {
    private var result = 0;

    init {
        if (input.isBlank()) throw IllegalArgumentException("공백 문자는 올 수 없습니다.")
    }

    fun result(): Int {
        calculate()
        return result
    }

    private fun calculate() {
        val list = input.split(" ")
        var result = list[0].toInt()
        for (i in 1 until list.size) {
            if (!NUMBER_REGEX.matcher(list[i]).matches()) {
                result = StringArithmetic.from(
                    arithmetic = list[i],
                    currentNumber = result,
                    nextNumber = list[i + 1].toInt()
                )
            }
        }
        this.result = result
    }

    companion object {
        private val NUMBER_REGEX = Pattern.compile("[0-9]+")
    }
}