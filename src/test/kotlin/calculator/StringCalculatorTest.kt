package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({

    test("덧셈 연산") {
        StringCalculator.calculate("1 + 2") shouldBe 3
    }

    test("뺄셈 연산") {
        StringCalculator.calculate("1 - 2") shouldBe -1
    }

    test("곱셈 연산") {
        StringCalculator.calculate("3 * 2") shouldBe 6
    }

    test("나눗셈 연산") {
        StringCalculator.calculate("6 / 2") shouldBe 3
    }
})
