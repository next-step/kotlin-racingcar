package calculator.domain.operation.command

import calculator.domain.operation.model.BinaryInputCommand

interface OperationCommand<T> {
    fun operate(input: BinaryInputCommand): T
}
