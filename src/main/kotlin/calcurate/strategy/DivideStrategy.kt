package calcurate.strategy

import calcurate.ErrorCode

class DivideStrategy : CalcStrategy {
    override val symbol = Companion.symbol
    override fun calc(prev: Double, next: Double): Double {
        if (next == .0) throw IllegalArgumentException(ErrorCode.INVALID_DIVIDE_VALUE.msg)
        return prev / next
    }

    companion object {
        const val symbol = "/"
    }
}
