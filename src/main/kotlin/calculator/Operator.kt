package calculator

import calculator.common.ExceptionCode

interface Operator {
    fun add(firstNum: Float, secondNum: Float): Float

    fun minus(firstNum: Float, secondNum: Float): Float

    fun multiple(firstNum: Float, secondNum: Float): Float

    fun divide(firstNum: Float, secondNum: Float): Float
}

class OperatorImpl : Operator {

    override fun add(firstNum: Float, secondNum: Float): Float = firstNum + secondNum

    override fun minus(firstNum: Float, secondNum: Float): Float = firstNum - secondNum

    override fun multiple(firstNum: Float, secondNum: Float): Float = firstNum * secondNum

    override fun divide(firstNum: Float, secondNum: Float): Float {
        if (secondNum == 0F) {
            throw IllegalArgumentException(ExceptionCode.NOT_DIVIDE_ZERO.getMessage())
        }
        return firstNum / secondNum
    }
}
