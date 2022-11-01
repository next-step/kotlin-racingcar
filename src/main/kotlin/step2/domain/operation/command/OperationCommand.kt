package step2.domain.operation.command

import step2.domain.operation.model.BinaryInputOperationCommand

interface OperationCommand {
    fun operate(input: BinaryInputOperationCommand): Int
}
