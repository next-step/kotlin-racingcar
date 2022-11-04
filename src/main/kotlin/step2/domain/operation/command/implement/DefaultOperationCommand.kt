package step2.domain.operation.command.implement

import step2.domain.operation.command.OperationCommand
import step2.domain.operation.model.BinaryInputCommand

object DefaultOperationCommand : OperationCommand<Int> {
    override fun operate(input: BinaryInputCommand) = 1
}
