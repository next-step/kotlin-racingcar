package step2.calculable.strategy

import step2.calculable.Calculable
import java.lang.Math.multiplyExact

class MultiplyCalculableStrategy : Calculable {
    companion object {
        const val MULTIPLICATION_SIGN = "*"
    }
    override fun calculate(x: Int, y: Int) = multiplyExact(x, y)
}
