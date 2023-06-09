package step2

import java.math.BigDecimal

/**
 * ### 연산식의 요소 중 하나인 '피연산자' 입니다.
 *
 * '연산자'에 의해 연산이 호출될때 실제로 계산하는 역할을 담당합니다.
 */
class Operand(operand: String) : ExpressionItem {
    private val value: BigDecimal = BigDecimal(operand)

    operator fun plus(target: Operand): Operand {
        return Operand((value + target.value).toString())
    }

    operator fun minus(target: Operand): Operand {
        return Operand((value - target.value).toString())
    }
    operator fun times(target: Operand): Operand {
        return Operand((value * target.value).toString())
    }

    operator fun div(target: Operand): Operand {
        return Operand((value / target.value).toString())
    }

    override fun toString(): String {
        return value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Operand

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
