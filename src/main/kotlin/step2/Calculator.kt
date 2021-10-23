package step2

import step2.module.ParserModule
import java.util.Queue

class Calculator(private val calculatorParser: ParserModule) {

    fun running(input: String): Double {
        val queue: Queue<String> = calculatorParser.parse(input)

        var result: Double = queue.poll().toDouble()

        while (queue.isNotEmpty()) {

            val operator: String = queue.poll()
            val num = queue.poll().toDouble()

            result = Operator.execute(operator, result, num)
        }
        return result
    }
}
