package step2.domain.operation.command.implement

import step2.domain.operation.command.OperationCommand
import step2.domain.operation.model.BinaryInputOperationCommand

object DivisionOperationCommand : OperationCommand {
    override fun operate(input: BinaryInputOperationCommand) = input.firstNumber / input.secondNumber
}
