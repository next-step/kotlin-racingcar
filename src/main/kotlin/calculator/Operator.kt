package calculator

import java.math.BigDecimal

interface Operator {
    fun applicable(operator: String): Boolean
    fun apply(op1: BigDecimal, op2: BigDecimal): BigDecimal

    class PlusOperator : Operator {
        override fun applicable(operator: String): Boolean {
            return operator == "+"
        }

        override fun apply(op1: BigDecimal, op2: BigDecimal): BigDecimal {
            // return op1 + op2
            return op1.plus(op2)
        }
    }

    class MinusOperator : Operator {
        override fun applicable(operator: String): Boolean {
            return operator == "-"
        }

        override fun apply(op1: BigDecimal, op2: BigDecimal): BigDecimal {
            // return op1 - op2
            return op1.minus(op2)
        }
    }

    class MultiplyOperator : Operator {
        override fun applicable(operator: String): Boolean {
            return operator == "*"
        }

        override fun apply(op1: BigDecimal, op2: BigDecimal): BigDecimal {
            return op1.multiply(op2)
        }
    }

    class DivideOperator : Operator {
        override fun applicable(operator: String): Boolean {
            return operator == "/"
        }

        override fun apply(op1: BigDecimal, op2: BigDecimal): BigDecimal {
            return op1.divide(op2)
        }
    }
}
