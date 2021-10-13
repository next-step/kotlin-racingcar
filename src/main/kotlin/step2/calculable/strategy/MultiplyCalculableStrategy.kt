package step2.calculable.strategy

import step2.calculable.Calculable
import java.lang.Math.multiplyExact

class MultiplyCalculableStrategy : Calculable {
    override fun calculate(x: Int, y: Int) = multiplyExact(x, y)
}
