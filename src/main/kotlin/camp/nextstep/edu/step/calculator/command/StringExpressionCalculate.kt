package camp.nextstep.edu.step.calculator.command

import camp.nextstep.edu.step.calculator.domain.FinalResult
import camp.nextstep.edu.step.calculator.domain.Requester
import camp.nextstep.edu.step.calculator.factory.CalculateSimpleFactory

class StringExpressionCalculate : CalculateCommand {

    override fun calculate(requester: Requester): FinalResult {
        val numbers = requester.splitExpression()
        val result = CalculateSimpleFactory.calculateByStringExpressionNumbers(numbers)
        return FinalResult.of(medianResult = result)
    }

}
