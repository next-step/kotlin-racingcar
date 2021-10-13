package step2.calculable.strategy

import step2.calculable.Calculable
import java.lang.Math.floorDiv

class DivideCalculableStrategy : Calculable {
    companion object {
        const val DIVISION_SIGN = "/"
        const val DIVIDE_ZERO_MESSAGE = "0 으로 나눌수 없습니다."
        const val ZERO = 0
    }

    override fun calculate(x: Int, y: Int) =
        if (y != ZERO) floorDiv(x, y) else throw IllegalArgumentException(DIVIDE_ZERO_MESSAGE)
}
