package step2.strategy.calculable

import java.lang.Math.subtractExact

class SubtractCalculateStrategyStrategy : CalculateStrategy {
    override fun calculate(x: Int, y: Int) = subtractExact(x, y)

    companion object {
        const val MINUS_OPERATOR = "-"
    }
}
