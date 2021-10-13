package step2.calculable.strategy

import step2.calculable.Calculable
import java.lang.Math.floorDiv

class DivideCalculableStrategy : Calculable {
    companion object {
        const val DIVISION_SIGN = "/"
    }

    override fun calculate(x: Int, y: Int) = if (y != 0) floorDiv(x, y) else throw IllegalArgumentException()
}
