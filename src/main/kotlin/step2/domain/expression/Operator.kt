package step2.domain.expression

import step2.strategy.calculate.AddCalculateStrategyStrategy
import step2.strategy.calculate.AddCalculateStrategyStrategy.Companion.PLUS_OPERATOR
import step2.strategy.calculate.CalculateStrategy
import step2.strategy.calculate.DivideCalculateStrategyStrategy
import step2.strategy.calculate.DivideCalculateStrategyStrategy.Companion.DIVISION_OPERATOR
import step2.strategy.calculate.ModCalculateStrategyStrategy
import step2.strategy.calculate.ModCalculateStrategyStrategy.Companion.REMAINDER_OPERATOR
import step2.strategy.calculate.MultiplyCalculateStrategyStrategy
import step2.strategy.calculate.MultiplyCalculateStrategyStrategy.Companion.MULTIPLICATION_OPERATOR
import step2.strategy.calculate.SubtractCalculateStrategyStrategy
import step2.strategy.calculate.SubtractCalculateStrategyStrategy.Companion.MINUS_OPERATOR

enum class Operator(private val operator: String, private val calculateStrategy: CalculateStrategy) {
    PLUS(PLUS_OPERATOR, AddCalculateStrategyStrategy()),
    MINUS(MINUS_OPERATOR, SubtractCalculateStrategyStrategy()),
    MULTIPLICATION(MULTIPLICATION_OPERATOR, MultiplyCalculateStrategyStrategy()),
    DIVISION(DIVISION_OPERATOR, DivideCalculateStrategyStrategy()),
    REMAINDER(REMAINDER_OPERATOR, ModCalculateStrategyStrategy())
    ;

    fun calculate(x: Int, y:Int) = calculate(Operand(x), Operand(y))
    fun calculate(x: Operand, y: Operand) = Operand(calculateStrategy.calculate(x.operand, y.operand))

    companion object {
        private const val NOT_FOUND_OPERATOR_MESSAGE = "연산자를 찾을 수 없습니다."

        fun values(operator: String): Operator = values().asSequence()
            .find { it.operator == operator }
            ?: throw IllegalArgumentException(NOT_FOUND_OPERATOR_MESSAGE)
    }
}
