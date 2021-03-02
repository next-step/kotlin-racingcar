package calculator

import java.lang.IllegalArgumentException

interface Operator {
    val sign: String
    fun operate(oldNum: Double, newNum: Double): Double

    companion object {
        fun calculate(sign: String, oldNum: Double, newNum: Double): Double {
            return when (sign) {
                AddOperator.sign -> AddOperator.operate(oldNum, newNum)
                MinusOperator.sign -> MinusOperator.operate(oldNum, newNum)
                MultipleOperator.sign -> MultipleOperator.operate(oldNum, newNum)
                DivideOperator.sign -> DivideOperator.operate(oldNum, newNum)
                else -> throw IllegalArgumentException("사칙연산 기호가 아닌 잘못된 값이 전달되었습니다.")
            }
        }
    }
}

object AddOperator : Operator {
    override val sign: String
        get() = "+"

    override fun operate(oldNum: Double, newNum: Double): Double {
        return oldNum + newNum
    }
}

object MinusOperator : Operator {
    override val sign: String
        get() = "-"

    override fun operate(oldNum: Double, newNum: Double): Double {
        return oldNum - newNum
    }
}

object MultipleOperator : Operator {
    override val sign: String
        get() = "*"

    override fun operate(oldNum: Double, newNum: Double): Double {
        return oldNum * newNum
    }
}

object DivideOperator : Operator {
    override val sign: String
        get() = "/"

    override fun operate(oldNum: Double, newNum: Double): Double {
        return oldNum / newNum
    }
}
