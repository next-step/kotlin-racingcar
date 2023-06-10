package step2.expression

import java.math.BigDecimal

/**
 * ### 연산식의 요소 중 하나인 '피연산자' 입니다.
 *
 * '연산자'에 의해 연산이 호출될때 실제로 계산하는 역할을 담당합니다.
 */
data class Operand(private val operand: String) : ExpressionItem {
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
}
