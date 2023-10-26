package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class StringCalculatorCounterKoTest : BehaviorSpec({

    given("StringCalculatorCounter") {
        `when`("덧셈하면") {
            val input: String = "10 + 5"
            val result = StringCalculatorCounter(input).calculate()
            then("15.0") {
                result shouldBe 15.0
            }
        }

        `when`("입력값이 null 이거나 빈 공백 문자인 경우") {
            then("IllegalArgumentException") {
                shouldThrow<IllegalArgumentException> {
                    StringCalculatorCounter("")
                }
            }
        }

        `when`("사칙연산 기호가 아닌 문자를 포함한 경우 ") {
            then("IllegalArgumentException throw") {
                shouldThrow<IllegalArgumentException> {
                    StringCalculatorCounter("1 + 2 + 3 A 4")
                }
            }
        }

        `when`("사칙 연산을 모두 포함하면") {
            val input: String = "2 + 3 * 4 / 2"
            val result = StringCalculatorCounter(input).calculate()
            then("10.0") {
                result shouldBe 10.0
            }
        }
    }
})
