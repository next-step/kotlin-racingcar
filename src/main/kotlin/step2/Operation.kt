package step2

import java.util.function.BiFunction

/**
 *
 * @author Leo
 */
enum class Operation(val symbol: String, val calculation: BiFunction<Long, Long, Long>) {

    PLUS(Calculator.PLUS, { num1: Long, num2: Long -> num1 + num2 }),
    MINUS(Calculator.MINUS, { num1: Long, num2: Long -> num1 - num2 }),
    MULTIPLE(Calculator.MULTIPLE, { num1: Long, num2: Long -> num1 * num2 }),
    DIVIDE(Calculator.DIVIDE, { num1: Long, num2: Long -> num1 / num2 });

    companion object {
        fun findCalculation(symbol: String?): Operation {
            require(symbol != null && symbol != Calculator.SPACE && symbol != Calculator.EMPTY) {
                throw IllegalArgumentException("null, 빈 문자열, 공백은 허용되지 않습니다.")
            }

            require(values().map { it.symbol }.contains(symbol)) {
                throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
            }

            return values().first() { it.symbol == symbol }
        }
    }
}
