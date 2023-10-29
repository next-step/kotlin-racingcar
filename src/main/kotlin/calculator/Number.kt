package calculator

@JvmInline
value class Number(val number: Int) {

    constructor(number: String) : this(number.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닌 문자열 입니다."))

    fun sum(otherNumber: Number): Number {
        return Number(number + otherNumber.number)
    }

    fun subtract(otherNumber: Number): Number {
        return Number(number - otherNumber.number)
    }

    fun times(otherNumber: Number): Number {
        return Number(number * otherNumber.number)
    }

    fun div(otherNumber: Number): Number {
        return Number(number / otherNumber.number)
    }

    companion object {
        fun isNumber(number: String): Boolean {
            return number.toIntOrNull() != null
        }
    }
}
