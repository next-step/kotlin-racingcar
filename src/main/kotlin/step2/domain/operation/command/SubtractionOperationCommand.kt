package step2.domain.operation.command

import step2.domain.operation.model.InputOperationCommand

class SubtractionOperationCommand : OperationCommand {
    override fun operate(input: InputOperationCommand) = input.firstNumber - input.secondNumber
}
