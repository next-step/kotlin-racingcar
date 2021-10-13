package step2.calculable.strategy

import step2.calculable.Calculable
import java.lang.Math.subtractExact

class SubtractCalculableStrategy : Calculable {
    override fun calculate(x: Int, y: Int) = subtractExact(x, y)
}
