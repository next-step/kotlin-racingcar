package step2.calculable.strategy

import step2.calculable.Calculable
import java.lang.Math.floorMod

class ModCalculableStrategy : Calculable {
    companion object {
        const val REMAINDER_SIGN = "%"
    }
    override fun calculate(x: Int, y: Int) = floorMod(x, y)
}
