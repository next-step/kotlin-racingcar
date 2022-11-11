package step2

import step2.domain.Calculator
import step2.domain.Operand

fun main() {
    println("계산식을 입력해주세요.")
    val input = readLine() ?: throw IllegalArgumentException("입력값이 없습니다.")
    println(StringCalculator.calculate(input))
}

private const val INPUT_DELIMITER = " "

private const val EVEN_NUMBER = 2

class StringCalculator(input: String) {
    init {
        check(input.isNotBlank()) { "입력 값이 비어있습니다." }
        calculate(input)
    }

    companion object {
        fun calculate(s: String): Int {
            val input = s.split(INPUT_DELIMITER)
            require(input.size % EVEN_NUMBER != 0) { "입력된 원소의 갯수는 홀수여야 합니다." }
            var result = Operand(input[0])
            for (i in 1 until input.size step EVEN_NUMBER) {
                result = Calculator.calculate(input[i], result, Operand(input[i + 1]))
            }
            return result.value
        }
    }
}
