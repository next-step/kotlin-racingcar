import study.InputManager
import study.Operators
import study.StringCalculator
import study.StringNumbers

fun main() {
    val inputData: String = InputManager.inputData()
    val splitInputData: List<String> = InputManager.splitInputData(inputData)
    val groupByNumberAndOperator: List<List<String>> = InputManager.groupByNumberAndOperator(splitInputData)
    val stringNumbers = StringNumbers(groupByNumberAndOperator[0])
    val operators = Operators(groupByNumberAndOperator[1])
    val stringCalculator = StringCalculator(stringNumbers, operators)
    println(stringCalculator.calculate())
}
