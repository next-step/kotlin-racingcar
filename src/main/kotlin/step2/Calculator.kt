package step2

import java.lang.ArithmeticException

fun main() {
    println(Calculator(readLine().toString()).caculate())
}

class Calculator(private var inputText: String) {
    fun caculate(): Int {
        checkNullOrWhitespace(inputText)
        val splitedStringList = removeWhiteSpace(inputText)

        var result = splitedStringList[0].toInt()

        for (i: Int in 0..splitedStringList.size - 3 step (2)) { // ex) i == 0, 2, 4
            result = calculateWithOperator(result, splitedStringList[i + 2].toInt(), splitedStringList[i + 1])
        }
        return result
    }

    private fun checkNullOrWhitespace(inputString: String) {
        if (inputString.isNullOrBlank()) {
            throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자임.")
        }
    }

    private fun removeWhiteSpace(inputString: String): List<String> {
        return inputString.split(' ') // ex) 2, +, 3, *, 4, /, 2
    }

    private fun calculateWithOperator(x: Int, y: Int, operator: String): Int {
        return if (operator == "+") {
            x + y
        } else if (operator == "-") {
            x - y
        } else if (operator == "*") {
            x * y
        } else if (operator == "/") {
            if (y == 0) {
                throw ArithmeticException("0으로 나눌 수 없음.")
            }
            x / y
        } else {
            throw IllegalArgumentException("사칙연산 기호가 아님.")
        }
    }
}
