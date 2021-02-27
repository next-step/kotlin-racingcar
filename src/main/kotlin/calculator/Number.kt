package calculator

import java.lang.NumberFormatException

class Number private constructor(val value: Int) : Word {

    companion object {
        fun of(value: String): Number {
            val v = value.trim()
            if (v.isEmpty()) {
                throw IllegalArgumentException("the value must not empty")
            }

            try {
                return Number(v.toInt())
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("the value must number")
            }
        }
    }
}
