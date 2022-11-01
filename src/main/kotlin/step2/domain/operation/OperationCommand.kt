package step2.domain.operation

interface OperationCommand {
    fun operate(first: Int, second: Int): Int
}
