package calculator.operand

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OperandTest : StringSpec({
    "숫자가 아닌 문자가 입력되면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            Operand.of("+")
        }
    }

    "더하기 기능 테스트" {
        Operand.of("1.0") + Operand.of("2.0") shouldBe Operand.of(3.0)
    }

    "빼기 기능 테스트" {
        Operand.of("2.0") - Operand.of("1.0") shouldBe Operand.of(1.0)
    }

    "곱하기 기능 테스트" {
        Operand.of("5.0") * Operand.of("2.0") shouldBe Operand.of(10.0)
    }

    "나누기 기능 테스트" {
        Operand.of("10.0") / Operand.of("2.0") shouldBe Operand.of(5.0)
    }
})
