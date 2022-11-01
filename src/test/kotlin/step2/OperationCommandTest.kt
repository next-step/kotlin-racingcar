package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import step2.domain.operation.*

class OperationCommandTest {

    private lateinit var operationCommand: OperationCommand

    @Test
    internal fun `두 개의 인자는 연산이 된다`() {
        val firstElement = 1
        val secondElement = 2

        operationCommand = DefaultOperationCommand()
        val result = operationCommand.operate(firstElement, secondElement)
        assertThat(result).isNotNull
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2", "3,4"])
    internal fun `두 개의 인자를 더할 수 있다`(first: Int, second: Int) {
        operationCommand = AdditionOperationCommand()
        val result = operationCommand.operate(first, second)
        assertThat(result).isEqualTo(first + second)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2", "3,4"])
    internal fun `첫 번째 인자에서 두 번째 인자를 뺄 수 있다`(first: Int, second: Int) {
        operationCommand = SubtractionOperationCommand()
        val result = operationCommand.operate(first, second)
        assertThat(result).isEqualTo(first - second)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2", "3,4", "100,0"])
    internal fun `두 개의 인자를 곱할 수 있다`(first: Int, second: Int) {
        operationCommand = MultiplicationOperationCommand()
        val result = operationCommand.operate(first, second)
        assertThat(result).isEqualTo(first * second)
    }
}
