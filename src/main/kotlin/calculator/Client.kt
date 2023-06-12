package calculator

import calculator.operation.OperationParser
import calculator.operation.OperationValidator

fun main() {
    val inputOperation = readln()
    OperationValidator.validateOperation(inputOperation)
    val parsedOperation = OperationParser.parseOperation(inputOperation)

    val calculator = BasicCalculator()
    println(calculator.calculate(parsedOperation).value)
}
