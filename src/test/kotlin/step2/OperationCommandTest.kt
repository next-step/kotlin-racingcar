package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step2.domain.operation.DefaultOperationCommand
import step2.domain.operation.OperationCommand

class OperationCommandTest {

    @Test
    internal fun `두 개의 인자는 연산이 된다`() {
        val firstElement = 1
        val secondElement = 2

        val operationCommand: OperationCommand = DefaultOperationCommand()
        val result = operationCommand.operate(firstElement, secondElement)
        assertThat(result).isNotNull
    }
}
