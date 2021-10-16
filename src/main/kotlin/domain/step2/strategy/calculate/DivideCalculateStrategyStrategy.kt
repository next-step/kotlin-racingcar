package domain.step2.strategy.calculate

import java.lang.Math.floorDiv

class DivideCalculateStrategyStrategy : CalculateStrategy {

    override fun calculate(x: Int, y: Int) =
        if (y != ZERO) floorDiv(x, y) else throw IllegalArgumentException(DIVIDE_ZERO_MESSAGE)

    companion object {
        const val DIVISION_OPERATOR = "/"

        private const val ZERO = 0
        private const val DIVIDE_ZERO_MESSAGE = "0 으로 나눌수 없습니다."
    }
}
