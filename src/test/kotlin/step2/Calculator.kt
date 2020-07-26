package step2

import org.assertj.core.internal.bytebuddy.agent.builder.AgentBuilder

interface Stoi {
    fun StringtoInt(rows: String): List
}

interface Result {
    fun cal(a:Int,b:Int): Int
}

enum class Operate(val sym: String):Result {
    SUM("+") {
        override fun cal(a: Int, b: Int) = a + b
    },
    SUB("-") {
        override fun cal(a: Int, b: Int) = a - b
    },
    MUL("*") {
        override fun cal(a: Int, b: Int) = a * b
    },
    DIV("/") {
        override fun cal(a: Int, b: Int): Int {
            if (b == 0) throw ArithmeticException("0으로 나누면 값이 무한이 됩니다.")
            return a / b
        }
    }
}




class CalculatorforString(elements: String) {
    val element = elements.trim().split(" ")

    fun OperateSymbol(operatesymbol: String?) {
        if (operatesymbol.isNullOrBlank())
            throw IllegalArgumentException("공백이나 null값은 혀용이 되지 않습니다.")
    }
}

fun main() {

}