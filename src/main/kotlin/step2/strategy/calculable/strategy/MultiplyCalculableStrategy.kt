package step2.strategy.calculable.strategy

import step2.strategy.calculable.Calculable
import java.lang.Math.multiplyExact

class MultiplyCalculableStrategy : Calculable {
    companion object {
        const val MULTIPLICATION_SIGN = "*"
    }
    override fun calculate(x: Int, y: Int) = multiplyExact(x, y)
}
