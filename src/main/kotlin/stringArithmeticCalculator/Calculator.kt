package stringArithmeticCalculator

import java.util.regex.Pattern

class Calculator(input: String) {
    private var result = 0
    private var addFlag = false
    private val list = mutableListOf<String>()

    init {
        addList(input)
    }

    private fun addList(input: String) {
        list.addAll(splitString(input))
    }

    private fun splitString(input: String): List<String> {
        if (input.isBlank()) throw IllegalArgumentException("공백 문자는 올 수 없습니다.")
        input.split(" ").let {
            checkString(it)
            return it
        }
    }

    private fun checkString(it: List<String>) {
        for (i in it.indices) {
            when (i % 2) {
                0 -> if (addFlag) operationCheck(it, i) else numberCheck(it, i)
                1 -> if (addFlag) numberCheck(it, i) else operationCheck(it, i)
            }
        }
    }

    private fun numberCheck(it: List<String>, i: Int) {
        if (!NUMBER_REGEX.matcher(it[i]).matches()) throw IllegalArgumentException("${i + 1} 번째 문자는 숫자가 와야합니다.")
    }

    private fun operationCheck(it: List<String>, i: Int) {
        if (!OPERATION_REGEX.matcher(it[i]).matches()) throw IllegalArgumentException("${i + 1} 번째 문자는 기호(+,-,*,/)가 와야합니다.")
    }

    fun result(): Int {
        calculate()
        return result
    }

    private fun calculate() {
        var result = list[0].toInt()
        for (i in 1 until list.size) {
            if (OPERATION_REGEX.matcher(list[i]).matches()) {
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
        private val OPERATION_REGEX = Pattern.compile("[+\\-*/]")

        fun Calculator.add(input: String): Calculator {
            this.addFlag = true
            this.addList(input)
            return this
        }
    }
}
