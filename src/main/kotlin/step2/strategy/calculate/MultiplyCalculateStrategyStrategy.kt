package step2.strategy.calculate

import java.lang.Math.multiplyExact

class MultiplyCalculateStrategyStrategy : CalculateStrategy {

    override fun calculate(x: Int, y: Int) = multiplyExact(x, y)

    companion object {
        const val MULTIPLICATION_OPERATOR = "*"
    }
}
