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
            val operator = ArithmeticOperator.of(splitInput.poll())
            val operand = splitInput.poll().toLong()
            result = operator.operate(result, operand)
        }

        return result
    }
}
