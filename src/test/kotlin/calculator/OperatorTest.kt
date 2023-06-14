package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class OperatorTest : StringSpec({
    "사칙 연산자를 사용해 연산한다." {
        forAll(
            row(Operator.PLUS, 5, 4, 9),
            row(Operator.MINUS, 5, 4, 1),
            row(Operator.MULTIPLY, 5, 4, 20),
            row(Operator.DIVIDE, 5, 4, 1)
        ) { operator, operand1, operand2, expected ->
            val result = operator.operate(operand1, operand2)
            result shouldBe expected
        }
    }

    "정상적인 연산자를 찾는다" {
        val operator = Operator.findOperator("+")
        operator shouldBe Operator.PLUS
    }

    "0으로 나누기 연산을 수행할 시, 예외를 발생시킨다" {
        val operator = Operator.DIVIDE
        shouldThrow<IllegalArgumentException> {
            operator.operate(5, 0)
        }
    }
})
