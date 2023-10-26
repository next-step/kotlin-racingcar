package step2

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OperatorTest : StringSpec({

    "덧셈 테스트" {
        // given
        val operator = Operator.from("+")

        // when
        val actual = operator?.calculate(2, 3)

        // then
        actual shouldBe 5
    }

    "뺄셈 테스트" {
        // given
        val operator = Operator.from("-")

        // when
        val actual = operator?.calculate(2, 3)

        // then
        actual shouldBe -1
    }

    "곱셈 테스트" {
        // given
        val operator = Operator.from("*")

        // when
        val actual = operator?.calculate(2, 3)

        // then
        actual shouldBe 6
    }

    "나눗셈 테스트" {
        // given
        val operator = Operator.from("/")

        // when
        val actual = operator?.calculate(6, 2)

        // then
        actual shouldBe 3
    }
})
