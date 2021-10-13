package step2.calculable.strategy

import step2.calculable.Calculable
import java.lang.Math.addExact

class AddCalculableStrategy : Calculable {
    override fun calculate(x: Int, y: Int) = addExact(x, y)
}
