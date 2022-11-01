package step2.domain.operation

class AdditionOperationCommand : OperationCommand {
    override fun operate(first: Int, second: Int) = first + second
}
