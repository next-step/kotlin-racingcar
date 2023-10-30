package calculator

@JvmInline
value class Number(private val number: String) {
    init {
        require(number.isNumber()) { "숫자가 아닙니다." }
    }

    operator fun plus(other: Number): Number {
        return Number((this.getNumber() + other.getNumber()).toString())
    }

    operator fun minus(other: Number): Number {
        return Number((this.getNumber() - other.getNumber()).toString())
    }

    operator fun times(other: Number): Number {
        return Number((this.getNumber() * other.getNumber()).toString())
    }

    operator fun div(other: Number): Number {
        return Number((this.getNumber() / other.getNumber()).toString())
    }

    private fun String.isNumber(): Boolean {
        return this.matches(REGEX)
    }
    fun getNumber() = number.toInt()

    companion object {
        private val REGEX = Regex("^(0|-?[1-9]\\d*)$")
    }
}
