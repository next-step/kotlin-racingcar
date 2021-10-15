package step2.strategy.calculable

import java.lang.Math.floorMod

class ModCalculateStrategyStrategy : CalculateStrategy {

    override fun calculate(x: Int, y: Int) = floorMod(x, y)

    companion object {
        const val REMAINDER_OPERATOR = "%"
    }
}
