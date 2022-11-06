package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

internal class OperatorTest : FunSpec({
    context("올바른 연산자로 Operator를 만들 수 있다.") {
        withData(
            "+" to Operator.ADDITION,
            "-" to Operator.SUBTRACTION,
            "/" to Operator.DIVISION,
            "*" to Operator.MULTIPLICATION
        ) { (operand, operator) ->
            Operator.from(operand) shouldBe operator
        }
    }

    context("올바르지 않은 연산자일 경우 예외를 던진다.") {
        withData(
            nameFn = { "올바르지 않은 연산자일 경우 예외 : $it" },
            ts = listOf("!", "@", "#", "$")
        ) { operand ->
            shouldThrow<IllegalArgumentException> { Operator.from(operand) }
        }
    }

    context("연산자는 정해진 연산을 진행할 수 있다.") {
        data class OperatorTestData(
            val operator: Operator,
            val number1: Double,
            val number2: Double,
            val result: Double
        )

        withData(
            OperatorTestData(operator = Operator.ADDITION, number1 = 10.0, number2 = 2.0, result = 12.0),
            OperatorTestData(operator = Operator.SUBTRACTION, number1 = 1.0, number2 = 10.0, result = -9.0),
            OperatorTestData(operator = Operator.DIVISION, number1 = 13.0, number2 = 2.0, result = 6.5),
            OperatorTestData(operator = Operator.MULTIPLICATION, number1 = 1.1, number2 = 10.0, result = 11.0)
        ) { (operator, number1, number2, result) ->
            operator(number1, number2) shouldBe result
        }
    }
})
