package calculator

import java.util.LinkedList

object StringCalculator {

    fun evaluate(number: List<Int>, operator: List<Operator>): Int {
        val operandQueue = LinkedList<Int>(number)
        val operatorQueue = LinkedList<Operator>(operator)
        var result = operandQueue.poll()
        while (operandQueue.peek() != null) result = operatorQueue.poll().invoke(result, operandQueue.poll())
        return result
    }

    fun parsing(stringExpression: String?, result: (Pair<List<Int>, List<Operator>>) -> Unit) {
        if (stringExpression.isNullOrBlank())
            throw IllegalArgumentException("Null or blank string expression")
        result(TypeExtractor.extract(stringExpression.replace(" ", "")))
    }
}
