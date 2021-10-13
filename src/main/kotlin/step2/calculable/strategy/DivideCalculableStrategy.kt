package step2.calculable.strategy

import step2.calculable.Calculable
import java.lang.Math.floorDiv

class DivideCalculableStrategy : Calculable {
    override fun calculate(x: Int, y: Int) = floorDiv(x, y)
}
