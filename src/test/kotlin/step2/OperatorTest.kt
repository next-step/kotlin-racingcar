package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class OperatorTest : StringSpec({

    "사칙연산 기호가 아닌 테스트" {
        forAll(
            row("#"),
            row("$"),
            row("^")
        ) { symbol ->
            shouldThrow<IllegalArgumentException> {
                Operator.getBySymbol(symbol)
            }
        }
    }

    "덧셈 테스트" {
        Operator.PLUS.operate(1, 2) shouldBe 3
    }

    "뺄셈 테스트" {
        Operator.MINUS.operate(2, 1) shouldBe 1
    }

    "곱셈 테스트" {
        Operator.MULTIPLY.operate(5, 6) shouldBe 30
    }

    "나눗셈 테스트" {
        Operator.DIVIDE.operate(9, 3) shouldBe 3
    }
})
