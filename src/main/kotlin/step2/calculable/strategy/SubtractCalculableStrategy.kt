package step2.calculable.strategy

import step2.calculable.Calculable
import java.lang.Math.subtractExact

class SubtractCalculableStrategy : Calculable {
    companion object {
        const val MINUS_SIGN = "-"
    }
    override fun calculate(x: Int, y: Int) = subtractExact(x, y)
}
