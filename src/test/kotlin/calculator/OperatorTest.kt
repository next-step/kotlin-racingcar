package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OperatorTest : StringSpec({
    "덧셈 기호를 사용할 때" {
        val operation = Operator.of("+")
        operation.exec(5, 3) shouldBe 8
    }

    "뻴셈 기호를 사용할 때" {
        val operation = Operator.of("-")
        operation.exec(5, 3) shouldBe 2
    }

    "나눗셈 기호를 사용할 때" {
        val operation = Operator.of("/")
        operation.exec(6, 3) shouldBe 2
    }

    "곱하기 기호를 사용할 때" {
        val operation = Operator.of("*")
        operation.exec(6, 3) shouldBe 18
    }

    "올바르지 않은 기호를 사용할 때" {
        shouldThrow<IllegalArgumentException> {
            Operator.of("@")
        }.message shouldBe "사칙연산 기호를 사용하지 않았습니다."
    }
})
