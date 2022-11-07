package calculator.domain.operation.command.implement

import calculator.domain.operation.command.OperationCommand
import calculator.domain.operation.model.BinaryInputCommand

object MultiplicationOperationCommand : OperationCommand<Int> {
    override fun operate(input: BinaryInputCommand) = input.firstNumber * input.secondNumber
}
