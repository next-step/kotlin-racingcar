package step2

import java.util.Queue

class Calculator {

    private val parser = Parser()

    fun calculate(input: String) {
        val dataQueue: Queue<String> = parser.parse(input)
        var sum: Double = dataQueue.poll().toDouble()
    }
}
