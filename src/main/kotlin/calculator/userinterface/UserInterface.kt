package calculator.userinterface

interface UserInterface {
    fun showInput()
    fun inputMathExpression(): String
    fun showResult(result: Int)
    fun showErrorMessage(errorMessage: String)
}
