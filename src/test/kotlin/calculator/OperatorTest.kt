package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class OperatorTest: ShouldSpec({

    should("Operator는 문자열을 받아 Operator로 변환한다") {
        Operator.fromString("+") shouldBe Operator.ADDITION
        Operator.fromString("-") shouldBe Operator.SUBTRACTION
        Operator.fromString("*") shouldBe Operator.MULTIPLICATION
        Operator.fromString("/") shouldBe Operator.DIVISION
    }

    should("Operator는 문자열이 연산자가 아닐 경우 IllegalArgumentException을 던진다") {
        val exception = shouldThrow<IllegalArgumentException> {
            Operator.fromString("a")
        }
        exception.message shouldBe "a is not supported operator."
    }

    should("Operator는 두 숫자를 받아 연산을 수행한다") {
        Operator.ADDITION.calculate(Number(1.0), Number(2.0)).number shouldBe 3.0
        Operator.SUBTRACTION.calculate(Number(1.0), Number(2.0)).number shouldBe -1.0
        Operator.MULTIPLICATION.calculate(Number(1.0), Number(2.0)).number shouldBe 2.0
        Operator.DIVISION.calculate(Number(1.0), Number(2.0)).number shouldBe 0.5
    }
})