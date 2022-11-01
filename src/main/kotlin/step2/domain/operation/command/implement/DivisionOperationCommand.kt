package step2.domain.operation.command.implement

import step2.domain.operation.command.OperationCommand
import step2.domain.operation.model.InputOperationCommand

object DivisionOperationCommand : OperationCommand {
    override fun operate(input: InputOperationCommand) = input.firstNumber / input.secondNumber
}
