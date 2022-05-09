package operator

import operator.application.OperatorService
import operator.domain.Calculator
import operator.view.OperatorController

fun main() {
    val operatorController = OperatorController(OperatorService(Calculator()))

    val input: String? = readLine()
    require(input != null)

    println(operatorController.operator(input))
}
