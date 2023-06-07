package study.step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class CalculatorTest : BehaviorSpec({
    given("계산기 테스트") {
        val calculator = Calculator()
        `when`("10 + 5") {
            val expression = "10 + 5"
            val result = calculator.calculate(expression)
            then("15가 나와야한다.") {
                result shouldBe 15
            }
        }

        `when`("2 + 3 * 4 / 2") {
            val expression = "2 + 3 * 4 / 2"
            val result = calculator.calculate(expression)
            then("10이 나와야한다.") {
                result shouldBe 10
            }
        }

        `when`("입력값이 null 이거나 빈 값 일경우") {
            val expression1 = null
            val expression2 = ""
            val expression3 = " "
            then("IllegalArgumentException 에러가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    calculator.calculate(expression1)
                }.message shouldBe "문자열을 null 이거나 빈 문자열일 수 없습니다."

                shouldThrow<IllegalArgumentException> {
                    calculator.calculate(expression2)
                }.message shouldBe "문자열을 null 이거나 빈 문자열일 수 없습니다."

                shouldThrow<IllegalArgumentException> { calculator.calculate(expression3) }
            }
        }

        `when`("사칙연산 기호가 아닌 경우") {
            val expression = "2 + 3 * 4 & 2"
            then("IllegalArgumentException 에러가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    calculator.calculate(expression)
                }.message shouldBe "사칙연산 기호가 아닙니다."
            }
        }
    }
})
