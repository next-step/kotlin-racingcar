package calculator

import java.util.LinkedList
import java.util.Queue

object StringCalculator {

    private const val DELIMITER = " "
    fun calculate(input: String?): Long {
        require(!input.isNullOrBlank()) { "입력값이 null 또는 빈 문자열일 수 없습니다." }

        val splitInput: Queue<String> = LinkedList(input.split(DELIMITER))

        var result = splitInput.poll().toLong()
        while (splitInput.isNotEmpty()) {
            val operator = splitInput.poll()
            val operand = splitInput.poll().toLong()

            when (operator) {
                "+" -> result += operand
                "-" -> result -= operand
                "*" -> result *= operand
                "/" -> result /= operand
                else -> throw IllegalArgumentException("사용 가능한 사칙연산 기호는 [+, -, *, /]입니다.")
            }
        }

        return result
    }
}
