package operator

import operator.application.OperatorService
import operator.domain.Calculator
import operator.view.OperatorController

fun main() {
    val operatorController = OperatorController(OperatorService(Calculator()))

    var input = ""
    while (input.isEmpty()) {
        input = readLine() ?: throw IllegalArgumentException("null")
    }

    println(operatorController.operator(input))
}
