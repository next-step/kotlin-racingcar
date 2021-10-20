package step2.exception

sealed class ErrorMessage(message: String) : IllegalArgumentException(message) {
    class CustomException(calculatorMessage: CalculatorMessage) : ErrorMessage(calculatorMessage.message)
}
