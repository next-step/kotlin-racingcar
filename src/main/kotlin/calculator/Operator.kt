package calculator

import java.math.BigDecimal

enum class Operator(val operatorSymbol: String) : Operation {
    ADD("+") {
        override fun perform(firstOperand: Operand, secondOperand: Operand): Operand {
            return Operand(firstOperand.value + secondOperand.value)
        }
    },
    
    SUBTRACT("-") {
        override fun perform(firstOperand: Operand, secondOperand: Operand): Operand {
            return Operand(firstOperand.value - secondOperand.value)
        }
    },
    
    MULTIPLY("*") {
        override fun perform(firstOperand: Operand, secondOperand: Operand): Operand {
            return Operand(firstOperand.value * secondOperand.value)
        }
    },
    
    DIVIDE("/") {
        override fun perform(firstOperand: Operand, secondOperand: Operand): Operand {
            if (secondOperand.value == BigDecimal.ZERO) {
                throw IllegalArgumentException(CANNOT_BE_DIVIDED_BY_ZERO)
            }

            return Operand(firstOperand.value / secondOperand.value)
        }
    },
    ;
    
    companion object {
        const val CANNOT_BE_DIVIDED_BY_ZERO = "0으로 나눌 수 없습니다."
    }
}
