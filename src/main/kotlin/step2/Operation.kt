package step2

import java.util.function.BiFunction

/**
 *
 * @author Leo
 */
enum class Operation(val symbol: String, val calculation: BiFunction<Long, Long, Long>) {

    PLUS(Constant.PLUS, BiFunction { num1: Long, num2: Long -> num1 + num2 }),
    MINUS(Constant.MINUS, BiFunction { num1: Long, num2: Long -> num1 - num2 }),
    MULTIPLE(Constant.MULTIPLE, BiFunction { num1: Long, num2: Long -> num1 * num2 }),
    DIVIDE(Constant.DIVIDE, BiFunction { num1: Long, num2: Long -> num1 / num2 });

    companion object {
        fun findCalculation(symbol: String?): Operation {
            fun validate() {
                if (symbol == null || symbol == Constant.SPACE || symbol == Constant.EMPTY) {
                    throw IllegalArgumentException("null, 빈 문자열, 공백은 허용되지 않습니다.")
                }

                if (values().map { it.symbol }.none { it == symbol }) {
                    throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
                }
            }

            validate()
            return values().first() { it.symbol == symbol }
        }
    }
}
