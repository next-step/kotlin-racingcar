package calculator

/**
 * 연산이라는 객체를 표현하는 추상 클래스
 * 연산자를 정의하기 위한 [symbol] 값과 주어진 연산을 수행하는 [operate] 행동을 가진다.
 */
interface Operator {

    val symbol: Symbol

    fun operate(left: Int, right: Int): Int
}

enum class ArithmeticOperator(override val symbol: Symbol) : Operator {

    PLUS(Symbol("+")) {
        override fun operate(left: Int, right: Int): Int = left.plus(right)
    },
    SUBTRACT(Symbol("-")) {
        override fun operate(left: Int, right: Int): Int = left.minus(right)
    },
    MULTIPLY(Symbol("*")) {
        override fun operate(left: Int, right: Int): Int = left.times(right)
    },
    DIVIDE(Symbol("/")) {
        override fun operate(left: Int, right: Int): Int {
            if (right == 0) {
                throw ArithmeticException("divide by zero ($left / $right)")
            }
            return left.div(right)
        }
    }
}
