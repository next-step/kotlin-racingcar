package step2.domain.operation.command.implement

import step2.domain.operation.command.OperationCommand
import step2.domain.operation.model.InputOperationCommand

object DefaultOperationCommand : OperationCommand {
    override fun operate(input: InputOperationCommand) = 1
}
