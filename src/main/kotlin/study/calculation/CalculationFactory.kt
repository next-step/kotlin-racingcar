package study.calculation

class CalculationFactory {
    companion object {
        fun create(oper: String): Calculation = Operator.select(oper).calculation
    }
}
