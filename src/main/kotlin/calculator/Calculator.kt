package calculator

class Calculator {

    fun calculate(operation: String?) {
        require(!operation.isNullOrBlank())
    }
}