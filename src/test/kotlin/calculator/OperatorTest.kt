package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OperatorTest : StringSpec({

    "PLUS는 덧셈을 수행한다." {
        // when
        val result = Operator.PLUS.expression(Number.of("1"), Number.of("2"))

        // then
        result shouldBe Number.of("3")
    }

    "MINUS는 뺄셈을 수행한다." {
        // when
        val result = Operator.MINUS.expression(Number.of("1"), Number.of("2"))

        // then
        result shouldBe Number.of("-1")
    }

    "MULTIPLE는 곱셈을 수행한다." {
        // when
        val result = Operator.MULTIPLE.expression(Number.of("2"), Number.of("2"))

        // then
        result shouldBe Number.of("4")
    }

    "DIVISION은 나눗셈을 수행한다." {
        // when
        val result = Operator.DIVISION.expression(Number.of("6"), Number.of("2"))

        // then
        result shouldBe Number.of("3")
    }
})
