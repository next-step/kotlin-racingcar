package step2

import step2.module.ParserModule
import java.util.Queue

class Running(private val parser: ParserModule) {

    fun running(input: String): Double {
        val queue: Queue<String> = parser.parse(input)

        var result: Double = queue.poll().toDouble()

        while (queue.isEmpty()) {

            val operator: String = queue.poll()
            val num = queue.poll().toDouble()

            result += Calculator.execute(operator, result, num)
        }
        return result
    }
}
