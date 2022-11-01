package step2.domain.operation

class DivisionOperationCommand : OperationCommand {
    override fun operate(first: Int, second: Int): Int {
        return first / second
    }
}
