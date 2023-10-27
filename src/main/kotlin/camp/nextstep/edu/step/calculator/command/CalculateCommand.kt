package camp.nextstep.edu.step.calculator.command

import camp.nextstep.edu.step.calculator.domain.FinalResult
import camp.nextstep.edu.step.calculator.domain.Requester

interface CalculateCommand {

    fun calculate(requester: Requester): FinalResult

}
