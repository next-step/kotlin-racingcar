package step2.strategy.calculable

import java.lang.Math.addExact

class AddCalculateStrategyStrategy : CalculateStrategy {

    override fun calculate(x: Int, y: Int) = addExact(x, y)

    companion object {
        const val PLUS_OPERATOR = "+"
    }
}
