package step2.domain.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step2.domain.calculator.impl.StandardCalculator
import step2.domain.calculator.model.InputOperationCommand
import step2.domain.operation.enums.Operator

internal class StandardCalculatorTest {

    private lateinit var calculator: Calculator

    companion object {
        private lateinit var defaultInputOperationCommandList: List<InputOperationCommand>
    }

    @Test
    fun `뎃셈 계산`() {
        defaultInputOperationCommandList = listOf(
            InputOperationCommand(1, Operator.ADDITION),
            InputOperationCommand(2, Operator.ADDITION),
            InputOperationCommand(3, Operator.ADDITION),
            InputOperationCommand(4, null)
        )

        calculator = StandardCalculator()
        val result = calculator.calculate(defaultInputOperationCommandList)
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `혼합 계산`() {
        defaultInputOperationCommandList = listOf(
            InputOperationCommand(1, Operator.ADDITION),
            InputOperationCommand(2, Operator.MULTIPLICATION),
            InputOperationCommand(3, Operator.SUBTRACTION),
            InputOperationCommand(4, null)
        )

        calculator = StandardCalculator()
        val result = calculator.calculate(defaultInputOperationCommandList)
        assertThat(result).isEqualTo(5)
    }
}
