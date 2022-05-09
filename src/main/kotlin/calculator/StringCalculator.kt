package calculator

import java.util.function.BiFunction

class StringCalculator {

    companion object {
        fun calculate(input: String): String {
            val values = input.split(" ")

            val iterator = values.listIterator()
            var result: Number = Number.of(iterator.next())
            while (iterator.hasNext()) {
                result = Operator.of(iterator.next()).calculate(result, Number.of(iterator.next()))
            }
            return result.parseString()
        }
    }
}

data class Number(val value: Long) {
    fun plus(other: Number) = Number(this.value.plus(other.value))

    fun minus(other: Number) = Number(this.value.minus(other.value))

    fun multiply(other: Number) = Number(this.value.times(other.value))

    fun parseString(): String {
        return this.value.toString()
    }

    companion object {
        fun of(str: String): Number {
            return Number(str.toLong())
        }
    }
}

enum class Operator(val value: String, val expression: BiFunction<Number, Number, Number>) {
    PLUS(value = "+", expression = { number1: Number, number2: Number -> number1.plus(number2) }),
    MINUS(value = "-", expression = { number1: Number, number2: Number -> number1.minus(number2) }),
    MULTIPLE(value = "*", expression = { number1: Number, number2: Number -> number1.multiply(number2) });

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
