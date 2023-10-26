package camp.nextstep.edu.step.calculator.domain

import camp.nextstep.edu.step.calculator.command.CalculateCommand

data class Calculator(
    val calculator: CalculateCommand
) {
    fun calculateExpression(requester: Requester): FinalResult {
        return calculator.calculate(requester)
    }

}
