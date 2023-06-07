package calculator

import calculator.Operation.Companion.numberOperation
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

@DisplayName("연산자")
class OperationTest : StringSpec({

    "사칙 연산 기호의 문자열은 사칙 연산으로 변경" {
        listOf(
            "+" to Operation.PLUS,
            "-" to Operation.MINUS,
            "*" to Operation.MULTIPLY,
            "/" to Operation.DIVIDE,
        ).forAll {
            it.first.numberOperation shouldBe it.second
        }
    }

    "일치하는 연산자기호가 존재하지 않으면 IllegalArgumentException" {
        listOf("!", "@", "#", "=")
            .forAll {
                shouldThrowExactly<IllegalArgumentException> {
                    it.numberOperation
                }
            }
    }

    "4, 2 값에 대한 사칙연산 계산" {
        listOf(
            Operation.PLUS to 6,
            Operation.MINUS to 2,
            Operation.MULTIPLY to 8,
            Operation.DIVIDE to 2,
        ).forAll {
            it.first.calculate(4, 2) shouldBe it.second
        }
    }

    "0으로 나눌 수 없음" {
        shouldThrowExactly<IllegalArgumentException> { Operation.DIVIDE.calculate(10, 0) }
    }
})
