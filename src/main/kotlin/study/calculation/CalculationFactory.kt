package study.calculation

import java.lang.IllegalArgumentException

class CalculationFactory {
    companion object {
        fun create(oper: String): Calculation = Operator.select(oper).calculation
    }
}
