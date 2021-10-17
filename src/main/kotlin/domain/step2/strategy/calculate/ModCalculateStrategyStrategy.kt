package domain.step2.strategy.calculate

import java.lang.Math.floorMod

class ModCalculateStrategyStrategy : CalculateStrategy {

    override fun calculate(x: Int, y: Int) = floorMod(x, y)

    companion object {
        const val REMAINDER_OPERATOR = "%"
    }
}
