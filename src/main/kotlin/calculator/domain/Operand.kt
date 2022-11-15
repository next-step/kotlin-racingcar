package calculator.domain

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class Operand(val operands: ArrayList<Double>) {

    init {
        for (operand in operands) {
            checkValidNumber(operand.toString())
        }
    }

    private fun checkValidNumber(input: String) {
        try {
            input.toDouble()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Invalid Operand")
        }
    }

    fun getOperandValues(index: Int): Double {
        return operands[index]
    }
}
