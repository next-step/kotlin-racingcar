package calculator.domain.operator.command

import calculator.domain.operation.command.OperationCommand
import calculator.domain.operation.command.implement.AdditionOperationCommand
import calculator.domain.operation.command.implement.DivisionOperationCommand
import calculator.domain.operation.command.implement.MultiplicationOperationCommand
import calculator.domain.operation.command.implement.SubtractionOperationCommand
import calculator.domain.operation.model.BinaryInputCommand
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

internal class OperationCommandKoTest : FreeSpec({

    lateinit var operationCommand: OperationCommand<Int>

    "두 개의 인자는 연산이 된다" {
        val first = 1
        val second = 2
        val input = createInputOperationCommand(first, second)

        operationCommand = AdditionOperationCommand
        val result = operationCommand.operate(input)
        result.shouldNotBeNull()
    }

    "두 개의 인자를 더할 수 있다" - {
        listOf(
            1 to 2,
            3 to 4
        ).forEach { (first: Int, second: Int) ->
            "$first + $second = ${first + second}" {
                val input = createInputOperationCommand(first, second)
                operationCommand = AdditionOperationCommand
                val result = operationCommand.operate(input)
                result shouldBe first + second
            }
        }
    }

    "첫 번째 인자에서 두 번째 인자를 뺄 수 있다" - {
        listOf(
            1 to 2,
            3 to 4
        ).forEach { (first: Int, second: Int) ->
            "$first - $second = ${first - second}" {
                val input = createInputOperationCommand(first, second)
                operationCommand = SubtractionOperationCommand
                val result = operationCommand.operate(input)
                result shouldBe first - second
            }
        }
    }

    "두 개의 인자를 곱할 수 있다" - {
        listOf(
            1 to 2,
            3 to 4,
            100 to 0
        ).forEach { (first: Int, second: Int) ->
            "$first * $second = ${first * second}" {
                val input = createInputOperationCommand(first, second)
                operationCommand = MultiplicationOperationCommand
                val result = operationCommand.operate(input)
                result shouldBe first * second
            }
        }
    }

    "첫 번째 인자에서 두 번째 인자를 나눌 수 있다" - {
        listOf(
            1 to 2,
            3 to 4
        ).forEach { (first: Int, second: Int) ->
            "$first / $second = ${first / second}" {
                val input = createInputOperationCommand(first, second)
                operationCommand = DivisionOperationCommand
                val result = operationCommand.operate(input)
                result shouldBe first / second
            }
        }
    }
})

private fun createInputOperationCommand(first: Int, second: Int) = BinaryInputCommand(first, second)
