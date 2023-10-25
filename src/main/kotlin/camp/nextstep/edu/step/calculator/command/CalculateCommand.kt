package camp.nextstep.edu.step.calculator.command

import camp.nextstep.edu.step.calculator.domain.Requester
import camp.nextstep.edu.step.calculator.domain.Result

interface CalculateCommand {

    fun calculate(requester: Requester): Result

}
