package step2.domain.expression

import step2.strategy.calculable.CalculateStrategy
import step2.strategy.calculable.AddCalculateStrategyStrategy
import step2.strategy.calculable.AddCalculateStrategyStrategy.Companion.PLUS_OPERATOR
import step2.strategy.calculable.DivideCalculateStrategyStrategy
import step2.strategy.calculable.DivideCalculateStrategyStrategy.Companion.DIVISION_OPERATOR
import step2.strategy.calculable.ModCalculateStrategyStrategy
import step2.strategy.calculable.ModCalculateStrategyStrategy.Companion.REMAINDER_OPERATOR
import step2.strategy.calculable.MultiplyCalculateStrategyStrategy
import step2.strategy.calculable.MultiplyCalculateStrategyStrategy.Companion.MULTIPLICATION_OPERATOR
import step2.strategy.calculable.SubtractCalculateStrategyStrategy
import step2.strategy.calculable.SubtractCalculateStrategyStrategy.Companion.MINUS_OPERATOR

enum class Operator(private val operator: String, private val calculateStrategy: CalculateStrategy) {
    PLUS(PLUS_OPERATOR, AddCalculateStrategyStrategy()),
    MINUS(MINUS_OPERATOR, SubtractCalculateStrategyStrategy()),
    MULTIPLICATION(MULTIPLICATION_OPERATOR, MultiplyCalculateStrategyStrategy()),
    DIVISION(DIVISION_OPERATOR, DivideCalculateStrategyStrategy()),
    REMAINDER(REMAINDER_OPERATOR, ModCalculateStrategyStrategy())
    ;

    fun calculate(x: Int, y: String) = calculate(x, Integer.valueOf(y))
    fun calculate(x: Int, y: Int) = calculateStrategy.calculate(x, y)

    companion object {
        private const val NOT_FOUND_OPERATOR_MESSAGE = "연산자를 찾을 수 없습니다."

        fun values(operator: String): Operator = values().asSequence()
            .find { it.operator == operator }
            ?: throw IllegalArgumentException(NOT_FOUND_OPERATOR_MESSAGE)
    }
}
