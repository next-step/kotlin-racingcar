package step2

import java.util.Queue

class Calculator(private val parser: Parser) {

    fun calculate(input: String?): Double {
        val dataQueue: Queue<String> = parser.parse(input)
        var sum: Double = dataQueue.poll().toDouble()
        while (!dataQueue.isEmpty()) {
            val operator = dataQueue.poll()
            val operand = dataQueue.poll().toDouble()
            sum = Operator.apply(value = operator, sum = sum, operand = operand)
        }
        return sum
    }
}
