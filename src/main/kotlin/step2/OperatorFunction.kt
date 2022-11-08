package step2

import step2.OperatorSign.DIVIDE
import step2.OperatorSign.MINUS
import step2.OperatorSign.MULTIPLE
import step2.OperatorSign.PLUS

object OperatorFunction {
    val plus = { a: Int, b: Int -> a + b }

    val minus = { a: Int, b: Int -> a - b }

    val multiple = { a: Int, b: Int -> a * b }

    val divide = { a: Int, b: Int -> a / b }

    fun get(operatorSign: OperatorSign): (a: Int, b: Int) -> Int {
        return when (operatorSign) {
            PLUS -> this.plus
            MINUS -> this.minus
            MULTIPLE -> this.multiple
            DIVIDE -> this.divide
        }
    }
}
