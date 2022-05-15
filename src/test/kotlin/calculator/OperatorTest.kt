package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OperatorTest : StringSpec({

    "PLUS는 덧셈을 수행한다." {
        // when
        val result = Operator.PLUS.calculate(Operand.of("1"), Operand.of("2"))

        // then
        result shouldBe Operand.of("3")
    }

    "MINUS는 뺄셈을 수행한다." {
        // when
        val result = Operator.MINUS.calculate(Operand.of("1"), Operand.of("2"))

        // then
        result shouldBe Operand.of("-1")
    }

    "MULTIPLE는 곱셈을 수행한다." {
        // when
        val result = Operator.MULTIPLE.calculate(Operand.of("2"), Operand.of("2"))

        // then
        result shouldBe Operand.of("4")
    }

    "DIVISION은 나눗셈을 수행한다." {
        // when
        val result = Operator.DIVISION.calculate(Operand.of("6"), Operand.of("2"))

        // then
        result shouldBe Operand.of("3")
    }
})
