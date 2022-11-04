package step2.domain.operation.command

import step2.domain.operation.model.BinaryInputCommand

interface OperationCommand<T> {
    fun operate(input: BinaryInputCommand): T
}
