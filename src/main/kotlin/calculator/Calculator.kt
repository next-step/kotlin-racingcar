package calculator

object Calculator {

    fun applyOperation(currentResult: Int, nextValue: Int, operation: Operation): Int {
        return when (operation) {
            Operation.PLUS -> currentResult.plus(nextValue)
            Operation.MINUS -> currentResult.minus(nextValue)
            Operation.MULTIPLY -> currentResult.times(nextValue)
            Operation.DIVIDE -> currentResult.div(nextValue)
        }
    }
}
