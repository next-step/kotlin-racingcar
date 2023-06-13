package calculator.operation

import java.lang.IllegalArgumentException

object OperationValidator {

    fun validateOperation(operation: String?) {
        if (operation.isNullOrEmpty()) throw IllegalArgumentException("Operation can't be null or empty")
    }
}
