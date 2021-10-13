package step2.domain

import step2.calculable.Calculable
import step2.calculable.strategy.AddCalculableStrategy
import step2.calculable.strategy.AddCalculableStrategy.Companion.PLUS_SIGN
import step2.calculable.strategy.DivideCalculableStrategy
import step2.calculable.strategy.DivideCalculableStrategy.Companion.DIVISION_SIGN
import step2.calculable.strategy.ModCalculableStrategy
import step2.calculable.strategy.ModCalculableStrategy.Companion.REMAINDER_SIGN
import step2.calculable.strategy.MultiplyCalculableStrategy
import step2.calculable.strategy.MultiplyCalculableStrategy.Companion.MULTIPLICATION_SIGN
import step2.calculable.strategy.SubtractCalculableStrategy
import step2.calculable.strategy.SubtractCalculableStrategy.Companion.MINUS_SIGN

enum class Operator(private val operator: String, private val calculable: Calculable) {
    PLUS(PLUS_SIGN, AddCalculableStrategy()),
    MINUS(MINUS_SIGN, SubtractCalculableStrategy()),
    MULTIPLICATION(MULTIPLICATION_SIGN, MultiplyCalculableStrategy()),
    DIVISION(DIVISION_SIGN, DivideCalculableStrategy()),
    REMAINDER(REMAINDER_SIGN, ModCalculableStrategy())
    ;

    companion object {
        const val NOT_FOUND_OPERATOR_MESSAGE = "연산자를 찾을 수 없습니다."

        fun values(operator: String): Operator = values().asSequence()
            .find { it.operator == operator }
            ?: throw IllegalArgumentException(NOT_FOUND_OPERATOR_MESSAGE)
    }

    fun calculate(x: Int, y: String) = calculate(x, Integer.valueOf(y))
    private fun calculate(x: Int, y: Int) = calculable.calculate(x, y)
}
