package step2.calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

internal class OperationTypeKoTest : StringSpec({
    "문자열 연산자에 따른 연산자 타입을 반환한다." {
        forAll(
            table(
                headers("문자열 연산자", "연산자 타입"),
                row("+", OperationType.PLUS),
                row("-", OperationType.MINUS),
                row("*", OperationType.MULTIPLY),
                row("/", OperationType.DIVIDE)
            )
        ) { given: String, expected: OperationType ->
            OperationType.match(given) shouldBe expected
        }
    }

    "정의된 연산자 타입이 아닌 경우 예외가 발생한다." {
        val given = "%"
        shouldThrow<IllegalArgumentException> {
            OperationType.match(given)
        }
    }

    "연산자 타입에 해당하는 수식을 연산한다." {
        val leftOperand = 4.0
        val rightOperand = 2.0
        forAll(
            table(
                headers("문자열 연산자", "연산 결과 기대값"),
                row("+", 6.0),
                row("-", 2.0),
                row("*", 8.0),
                row("/", 2.0),
            )
        ) { given: String, expected: Double ->
            OperationType.match(given).calculate(leftOperand, rightOperand) shouldBe expected
        }
    }

    "제수가 0인 경우 에외가 발생한다." {
        val operationType = OperationType.DIVIDE
        val given = 0.0
        forAll(
            row(Double.POSITIVE_INFINITY),
            row(Double.NEGATIVE_INFINITY)
        ) { leftOperand: Double ->
            shouldThrow<IllegalArgumentException> {
                operationType.calculate(leftOperand, given)
            }
        }
    }
})
