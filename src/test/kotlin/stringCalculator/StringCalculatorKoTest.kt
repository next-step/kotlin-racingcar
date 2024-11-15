package stringCalculator

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorKoTest : StringSpec({
    "입력값이 null일 경우 예외를 반환한다. " {
        val calculator = StringCalculator()
        shouldThrow<IllegalArgumentException> {
            calculator.calculate(null)
        }
    }

    "입력값이 공백 문자일 경우 예외를 반환한다. " {
        val calculator = StringCalculator()

        assertSoftly {
            shouldThrow<IllegalArgumentException> {
                calculator.calculate("")
            }
            shouldThrow<IllegalArgumentException> {
                calculator.calculate(" ")
            }
        }
    }
    "올바른 식이 아닐경우 예외를 반환한다." {
        val calculator = StringCalculator()

        assertSoftly {
            shouldThrow<IllegalArgumentException> {
                calculator.calculate("asdsd-a")
            }

            shouldThrow<IllegalArgumentException> {
                calculator.calculate("2 a 1")
            }
        }
    }

    "입력값에 대해 덧셈을 할 수 있다." {
        val calculator = StringCalculator()
        calculator.calculate("1 + 2") shouldBe 3
    }

    "입력값에 대해 뺄셈을 할 수 있다." {
        val calculator = StringCalculator()
        calculator.calculate("5 - 2") shouldBe 3
    }

    "입력값에 대해 곱셈을 할 수 있다." {
        val calculator = StringCalculator()
        calculator.calculate("5 * 2") shouldBe 10
    }

    "입력값에 대해 나눗셈을 할 수 있다." {
        val calculator = StringCalculator()
        calculator.calculate("10 / 2") shouldBe 5
    }
})
