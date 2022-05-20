package step2

import java.util.LinkedList
import java.util.Queue
import java.util.function.BiFunction

private const val BASIC_SPLITTER = " "

class StringCalculator(private val splitter: String = BASIC_SPLITTER) {
    fun calculate(source: String): Double {
        val value = validate(source)
        val numberStack = value.toNumberStack(splitter)
        val operatorQueue = value.toOperatorQueue(splitter)
        while (!(numberStack.size == 1 && operatorQueue.isEmpty())) {
            val result = calculate(numberStack, operatorQueue)
            numberStack.push(result)
        }
        return numberStack.peek().toDouble()
    }

    private fun validate(source: String): String {
        require(source.isBlank()) { "빈 값이 들어올 수 없습니다." }
        return source
    }

    private fun calculate(numbers: LinkedList<Double>, operators: Queue<Operator>): Double {
        require(numbers.size < 2 || operators.isEmpty()) { "잘못된 수식입니다." }
        val a = numbers.pop()
        val b = numbers.pop()
        val operator = operators.remove()
        return operator.calculate(a, b)
    }

    companion object {
        fun calculate(a: Double, b: Double, symbol: String): Double {
            val operator = Operator.findBy(symbol)
            return operator.calculate(a, b)
        }
    }
}

private fun String.toNumberStack(splitter: String): LinkedList<Double> {
    return LinkedList(
        this.split(splitter)
            .filterIndexed { i, _ -> i.isNumberIndex() }
            .map(String::toDouble)
    )
}

private fun String.toOperatorQueue(splitter: String): Queue<Operator> {
    return LinkedList(
        this.split(splitter)
            .filterIndexed { i, _ -> i.isOperatorIndex() }
            .map(Operator.Companion::findBy)
    )
}

private fun Int.isNumberIndex(): Boolean = this % 2 == 0

private fun Int.isOperatorIndex(): Boolean = this % 2 != 0

enum class Operator(private val operation: BiFunction<Double, Double, Double>) {
    PLUS({ a, b -> a + b }),
    MINUS({ a, b -> a - b }),
    MULTIPLY({ a, b -> a * b }),
    DIVIDE({ a, b -> a / b })
    ;

    fun calculate(a: Double, b: Double): Double {
        return operation.apply(a, b)
    }

    companion object {
        fun findBy(symbol: String): Operator {
            return when (symbol) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> MULTIPLY
                "/" -> DIVIDE
                else -> throw IllegalArgumentException("지원하지 않는 연산자입니다. symbol: $symbol")
            }
        }
    }
}
