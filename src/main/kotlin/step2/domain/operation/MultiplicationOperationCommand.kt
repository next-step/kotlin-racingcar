package step2.domain.operation

class MultiplicationOperationCommand : OperationCommand {
    override fun operate(first: Int, second: Int) = first * second
}
