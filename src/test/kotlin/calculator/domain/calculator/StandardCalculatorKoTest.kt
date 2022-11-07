package calculator.domain.calculator

import calculator.domain.calculator.impl.StandardCalculator
import calculator.domain.calculator.model.InputOperationCommand
import calculator.domain.operation.enums.Operator
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class StandardCalculatorKoTest : StringSpec({

    lateinit var calculator: Calculator<Int>

    beforeEach {
        calculator = StandardCalculator()
    }

    lateinit var defaultInputOperationCommandList: List<InputOperationCommand>

    "덧셈 계산" {
        defaultInputOperationCommandList = listOf(
            InputOperationCommand(1, Operator.ADDITION),
            InputOperationCommand(2, Operator.ADDITION),
            InputOperationCommand(3, Operator.ADDITION),
            InputOperationCommand(4, Operator.EMPTY_OPERATOR)
        )

        val result = calculator.calculate(defaultInputOperationCommandList)
        result shouldBe 10
    }

    "혼합 계산 - 1" {
        defaultInputOperationCommandList = listOf(
            InputOperationCommand(1, Operator.ADDITION),
            InputOperationCommand(2, Operator.MULTIPLICATION),
            InputOperationCommand(3, Operator.SUBTRACTION),
            InputOperationCommand(4, Operator.EMPTY_OPERATOR)
        )

        val result = calculator.calculate(defaultInputOperationCommandList)
        result shouldBe 5
    }

    "혼합 계산 - 2" {
        defaultInputOperationCommandList = listOf(
            InputOperationCommand(2, Operator.ADDITION),
            InputOperationCommand(3, Operator.MULTIPLICATION),
            InputOperationCommand(4, Operator.DIVISION),
            InputOperationCommand(2, Operator.EMPTY_OPERATOR)
        )

        val result = calculator.calculate(defaultInputOperationCommandList)
        result shouldBe 10
    }
})
