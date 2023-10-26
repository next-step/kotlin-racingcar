package calculator

object StringCalculator {

    fun applyOperation(currentResult: Int, nextValue: Int, operation: Operation): Int {
        return when (operation) {
            Operation.PLUS -> currentResult + nextValue
            Operation.MINUS -> currentResult - nextValue
            Operation.MULTIPLY -> currentResult * nextValue
            Operation.DIVIDE -> currentResult / nextValue
        }
    }
}
