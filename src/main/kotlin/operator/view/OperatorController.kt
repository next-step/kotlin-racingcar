package operator.view

import operator.application.OperatorService

class OperatorController(private val operatorService: OperatorService) {
    fun operator(input: String):Double = operatorService.operator(input)
}
