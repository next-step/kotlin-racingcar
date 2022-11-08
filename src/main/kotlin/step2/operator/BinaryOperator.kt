package step2.operator

interface BinaryOperator<T> {
    fun operate(left: T, right: T): T
}
