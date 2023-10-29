package calculator

class ChunkStringCalculator {
    companion object {
        fun calculate(operand1: String, operator: String, operand2: String): String {
            try {
                operand1.toInt()
                operand2.toInt()
            } catch (e: NumberFormatException) {
                throw NumberFormatException("숫자형이 아닌 피연산자가 들어왔다.")
            }

            return Operator.fromSymbol(operator).calcFunc(operand1.toInt(), operand2.toInt()).toString()
        }
    }
}
