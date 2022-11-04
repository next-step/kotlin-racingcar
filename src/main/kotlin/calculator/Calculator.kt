package calculator

class Calculator {

    fun calculate(operation: String?) {
        require(!operation.isNullOrBlank())
        require(isValid(operation))
        Operator("")
    }

    private fun isValid(operation: String): Boolean {
        TODO()
    }
}