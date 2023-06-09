package step2.calculator

fun main(args: Array<String>) {
    val inputData = Input.inputData()
    val tokenizedExpression = TokenizedExpression(inputData)

    val calculator = Calculator(tokenizedExpression)
    val result = calculator.calculate()

    Output.printResult(result)
}
