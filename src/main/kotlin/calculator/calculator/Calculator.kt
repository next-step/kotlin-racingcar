package calculator.calculator

interface Calculator {
    /**
     * Node 리스트를 받으면 정수로 결과를 반환 한다.
     */
    fun calculate(input: List<Node>): Int

    sealed class Error(message: String) : Exception(message) {
        object NumberIsMissing : Error("Number must be followed by an operator.")
        object OperatorIsMissing : Error("Operator must be followed by a number.")
    }
}
