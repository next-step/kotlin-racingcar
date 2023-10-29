package calculator

import java.util.LinkedList

class ChunkStringCalculator {
    companion object {
        fun calculate(operand1: String, operator: String, operand2: String): String {
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

            return chunkResult
        }
    }
}
