package calculator.operator

sealed interface Operator {
    fun operate(first: Int, second: Int): Int
}
