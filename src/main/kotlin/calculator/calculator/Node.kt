package calculator.calculator

/**
 * 노드는 피연산자 Number와 연산자 Operator로 구성 되어 있다.
 */
sealed class Node {
    /**
     * Number는 피연산자로 값을 가지고 있다.
     */
    data class Number(val value: Double) : Node()

    /**
     * Operator는 연산자로 피연산자의 값을 가지고 계산을 수행한다.
     */
    sealed class Operator : Node() {
        object Plus : Operator() {
            override fun operate(left: Number, right: Number) = Number(left.value + right.value)
        }

        object Minus : Operator() {
            override fun operate(left: Number, right: Number) = Number(left.value - right.value)
        }

        object Multiply : Operator() {
            override fun operate(left: Number, right: Number) = Number(left.value * right.value)
        }

        object Divide : Operator() {
            /**
             * 0으로 나눌 때 발생하는 Exception
             */
            class DivideByZeroException : Exception("Cannot divide by 0.")

            override fun operate(left: Number, right: Number) = if (right.value != 0.0) {
                Number(left.value / right.value)
            } else {
                throw DivideByZeroException()
            }
        }

        abstract fun operate(left: Number, right: Number): Number
    }
}
