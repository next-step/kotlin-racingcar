package step2.strategy.calculable.strategy

import step2.strategy.calculable.Calculable
import java.lang.Math.addExact

class AddCalculableStrategy : Calculable {
    companion object {
        const val PLUS_SIGN = "+"
    }
    override fun calculate(x: Int, y: Int) = addExact(x, y)
}
