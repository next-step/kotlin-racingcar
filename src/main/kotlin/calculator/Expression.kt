package calculator

import java.util.LinkedList
import java.util.Queue

fun buildExpressionQueue(sanitizedExpression: String): Queue<Any> {
    val queue: Queue<Any> = LinkedList()
    var currentNumber = ""
    for (char in sanitizedExpression) {
        currentNumber = if (char.isDigit()) {
            currentNumber + "" + char
        } else {
            queue.offer(currentNumber.toInt())
            queue.offer(char)
            ""
        }
    }
    queue.offer(currentNumber.toInt())
    return queue
}
