package step2

import step2.OperatorSign.DIVIDE
import step2.OperatorSign.MINUS
import step2.OperatorSign.MULTIPLE
import step2.OperatorSign.PLUS

object OperatorFunction {
    val plus = { a: Int, b: Int -> a + b }

    val minus = { a: Int, b: Int -> a - b }

    val multiple = { a: Int, b: Int -> a * b }

    val divide = { a: Int, b: Int ->
        if (b == 0) {
            throw IllegalStateException("0 으로 숫자를 나눌 수 없습니다.")
        }
        a / b
    }

    fun get(operatorSign: OperatorSign): (a: Int, b: Int) -> Int {
        return when (operatorSign) {
            PLUS -> this.plus
            MINUS -> this.minus
            MULTIPLE -> this.multiple
            DIVIDE -> this.divide
        }
    }
}
