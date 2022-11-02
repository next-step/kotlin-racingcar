package step2.domain.operation.command

import step2.domain.operation.model.BinaryInputCommand

interface OperationCommand {
    fun operate(input: BinaryInputCommand): Int
}
