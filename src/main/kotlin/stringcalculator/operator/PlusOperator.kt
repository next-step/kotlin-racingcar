package stringcalculator.operator

class PlusOperator : Operator {
    override fun character(): String {
        return "+"
    }

    override fun operate(x: Double, y: Double): Double {
        return x + y
    }
}
