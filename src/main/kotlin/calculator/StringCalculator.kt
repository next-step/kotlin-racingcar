package calculator

import java.util.function.BiFunction

class StringCalculator {

    companion object {
        fun calculate(input: String?): String {
            require(!input.isNullOrBlank()) { "문자열 계산기의 입력값은 null이거나 빈 값일 수 없습니다. input: $input" }
            val values = input.split(VALUE_DELIMITERS)
            val iterator = values.listIterator()
            var result: Number = Number.of(iterator.next())
            while (iterator.hasNext()) {
                result = Operator.of(iterator.next()).calculate(result, Number.of(iterator.next()))
            }
            return result.parseString()
        }

        private const val VALUE_DELIMITERS = " "
    }
}

enum class Operator(val value: String, val expression: BiFunction<Number, Number, Number>) {
    PLUS(value = "+", expression = { number1: Number, number2: Number -> number1.plus(number2) }),
    MINUS(value = "-", expression = { number1: Number, number2: Number -> number1.minus(number2) }),
    MULTIPLE(value = "*", expression = { number1: Number, number2: Number -> number1.multiply(number2) }),
    DIVISION(value = "/", expression = { number1: Number, number2: Number -> number1.divide(number2) }), ;

    fun calculate(number1: Number, number2: Number): Number {
        return this.expression.apply(number1, number2)
    }

    companion object {
        fun of(value: String): Operator {
            return values().firstOrNull { it.value == value }
                ?: throw IllegalArgumentException("지원하지 않는 연산자 입니다. operator: $value")
        }
    }
}
