package calculator.operation

abstract class Operator(val operator: String) {

    open fun match(operator: String) = this.operator == operator

    abstract fun operate(leftOperand: Double, rightOperand: Double): Double
}
