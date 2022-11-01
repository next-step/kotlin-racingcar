package step2.domain.operation

class SubtractionOperationCommand : OperationCommand {
    override fun operate(first: Int, second: Int) = first - second
}
