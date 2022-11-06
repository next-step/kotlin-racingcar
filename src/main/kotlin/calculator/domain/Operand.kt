package calculator.domain

data class Operand(val number: Double) {

    companion object {
        fun from(input: String): Operand = Operand(getValidateValue(input))

        private fun getValidateValue(number: String): Double {
            try {
                return number.toDouble()
            } catch (e: java.lang.NumberFormatException) {
                throw IllegalArgumentException("올바르지 않은 피연산자 타입입니다")
            }
        }
    }

    fun plus(operand: Operand): Double {
        return number.plus(operand.number)
    }

    fun minus(operand: Operand): Double {
        return number.minus(operand.number)
    }

    fun multiply(operand: Operand): Double {
        return number * operand.number
    }

    fun div(operand: Operand): Double {
        require(operand.number != 0.0) { "0으로는 나눌 수 없습니다" }
        return number / operand.number
    }

}
