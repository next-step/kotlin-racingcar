package step2.domain.operator.command

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import step2.domain.operation.command.OperationCommand
import step2.domain.operation.command.implement.AdditionOperationCommand
import step2.domain.operation.command.implement.DefaultOperationCommand
import step2.domain.operation.command.implement.DivisionOperationCommand
import step2.domain.operation.command.implement.MultiplicationOperationCommand
import step2.domain.operation.command.implement.SubtractionOperationCommand
import step2.domain.operation.model.InputOperationCommand

class OperationCommandTest {

    private lateinit var operationCommand: OperationCommand

    @Test
    internal fun `두 개의 인자는 연산이 된다`() {
        val first = 1
        val second = 2
        val input = createInputOperationCommand(first, second)

        operationCommand = DefaultOperationCommand
        val result = operationCommand.operate(input)
        assertThat(result).isNotNull
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2", "3,4"])
    internal fun `두 개의 인자를 더할 수 있다`(first: Int, second: Int) {
        val input = createInputOperationCommand(first, second)
        operationCommand = AdditionOperationCommand
        val result = operationCommand.operate(input)
        assertThat(result).isEqualTo(first + second)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2", "3,4"])
    internal fun `첫 번째 인자에서 두 번째 인자를 뺄 수 있다`(first: Int, second: Int) {
        val input = createInputOperationCommand(first, second)
        operationCommand = SubtractionOperationCommand
        val result = operationCommand.operate(input)
        assertThat(result).isEqualTo(first - second)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2", "3,4", "100,0"])
    internal fun `두 개의 인자를 곱할 수 있다`(first: Int, second: Int) {
        val input = createInputOperationCommand(first, second)
        operationCommand = MultiplicationOperationCommand
        val result = operationCommand.operate(input)
        assertThat(result).isEqualTo(first * second)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2", "3,4"])
    internal fun `첫 번째 인자에서 두 번째 인자를 나눌 수 있다`(first: Int, second: Int) {
        val input = createInputOperationCommand(first, second)
        operationCommand = DivisionOperationCommand
        val result = operationCommand.operate(input)
        assertThat(result).isEqualTo(first / second)
    }

    private fun createInputOperationCommand(first: Int, second: Int) = InputOperationCommand(first, second)
}
