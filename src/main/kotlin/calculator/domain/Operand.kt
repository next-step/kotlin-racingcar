package calculator.domain

import kotlin.IllegalArgumentException

data class Operand(val number: Double) {

    companion object {
        fun of(input: String): Operand = Operand(getValidatedValue(input))

        private fun getValidatedValue(number: String): Double {
            try {
                return number.toDouble()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("올바르지 않은 피연산자 타입입니다")
            }
        }
    }

    operator fun plus(rightOperand: Operand): Operand {
        return Operand(number + rightOperand.number)
    }

    operator fun minus(rightOperand: Operand): Operand {
        return Operand(number - rightOperand.number)
    }

    operator fun times(rightOperand: Operand): Operand {
        return Operand(number * rightOperand.number)
    }

    operator fun div(rightOperand: Operand): Operand {
        require(rightOperand.number != 0.0) { "0으로는 나눌 수 없습니다" }
        return Operand(number / rightOperand.number)
    }
}
