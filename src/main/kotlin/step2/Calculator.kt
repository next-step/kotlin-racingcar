package step2

import java.util.LinkedList
import java.util.Queue

class Calculator {
    /**
     * 외부로 노출되있는 함수
     */
    fun calculate(input: String?): Int {
        if (input == null || input.isBlank() || input.isEmpty())
            throw IllegalArgumentException("입력값이 null이거나 빈 공백이 아니여야합니다.")

        val signs: Queue<Char> = getSignQueue(input)
        val numbers: List<Int> = getNumbers(input)

        return numbers.reduce { total, number -> calculate(total, number, signs.poll()) }
    }

    /**
     * 숫자나 공백을 제외한 기호들을 큐로 반환한다.
     */
    private fun getSignQueue(input: String) = input.filterNot { it.isDigit() || it.isWhitespace() }
        .toList()
        .let { LinkedList<Char>(it) }

    /**
     * 숫자들을 리스트로 반환한다.
     */
    private fun getNumbers(input: String) = input.filter { it.isDigit() }.map { it.digitToInt() }

    /**
     * 숫자들 및 기호에 대한 연산결과를 반환하고, 사칙연산 외의 기호일 경우 exception을 던진다.
     */
    private fun calculate(left: Int, right: Int, sign: Char) = when (sign) {
        '+' -> left + right
        '-' -> left - right
        '*' -> left * right
        '/' -> left / right
        else -> throw IllegalArgumentException("수학기호는 +, -, *, / 만 허용됩니다.")
    }.also { result ->
        println("$left $sign $right = $result")
    }
}
