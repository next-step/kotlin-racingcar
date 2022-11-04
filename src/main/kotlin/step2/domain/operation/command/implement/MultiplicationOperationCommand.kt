package step2.domain.operation.command.implement

import step2.domain.operation.command.OperationCommand
import step2.domain.operation.model.BinaryInputCommand

object MultiplicationOperationCommand : OperationCommand<Int> {
    override fun operate(input: BinaryInputCommand) = input.firstNumber * input.secondNumber
}
