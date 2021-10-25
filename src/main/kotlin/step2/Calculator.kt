package step2

class Calculator {

    fun calculate(expression: String): Int {
        val values = expression.split(" ")
        return Operator.PLUS.operator.invoke(values[0].toInt(), values[2].toInt())
    }
}
