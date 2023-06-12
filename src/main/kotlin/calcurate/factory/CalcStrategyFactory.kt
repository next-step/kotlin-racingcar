package calcurate.factory

import calcurate.ErrorCode
import calcurate.strategy.AddStrategy
import calcurate.strategy.CalcStrategy
import calcurate.strategy.DivideStrategy
import calcurate.strategy.MultiplyStrategy
import calcurate.strategy.SubtractStrategy

class CalcStrategyFactory {
    companion object {
        fun selectCalcStrategy(symbol: String): CalcStrategy {
            return when (symbol) {
                AddStrategy.symbol -> AddStrategy()
                SubtractStrategy.symbol -> SubtractStrategy()
                MultiplyStrategy.symbol -> MultiplyStrategy()
                DivideStrategy.symbol -> DivideStrategy()
                else -> throw IllegalArgumentException(ErrorCode.INVALID_CALC_SYMBOL.msg)
            }
        }
    }
}
