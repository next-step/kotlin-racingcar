package calculator

import java.util.LinkedList

class ChunkStringCalculator private constructor(private val calculationDeque: LinkedList<String>) {
    fun calculate(): String {
        val operand1: String = calculationDeque.pollFirst()
        val operator: String = calculationDeque.pollFirst()
        val operand2: String = calculationDeque.pollFirst()

        try {
            operand1.toInt()
            operand2.toInt()
        } catch (e: NumberFormatException) {
            throw NumberFormatException("숫자형이 아닌 피연산자가 들어왔다.")
        }

        val chunkResult = when (Operator.fromSymbol(operator)) {
            Operator.PLUS -> Operator.PLUS.calcFunc(operand1.toInt(), operand2.toInt())
            Operator.MINUS -> Operator.MINUS.calcFunc(operand1.toInt(), operand2.toInt())
            Operator.MULTIPLY -> Operator.MULTIPLY.calcFunc(operand1.toInt(), operand2.toInt())
            Operator.DIVIDE -> Operator.DIVIDE.calcFunc(operand1.toInt(), operand2.toInt())
        }.toString() // wholeElements: List<String> 를 지워라

        calculationDeque.addFirst(chunkResult)
        return chunkResult
    }

    fun isContinued(): Boolean {
        return calculationDeque.size >= 3
    }

    fun isValidResult(): Boolean {
        return calculationDeque.size == 1
    }

    companion object {
        fun create(wholeElements: Collection<String>): ChunkStringCalculator {
            val calculationDeque = LinkedList<String>()
            calculationDeque.addAll(wholeElements)
            return ChunkStringCalculator(calculationDeque)
        }
    }
}
