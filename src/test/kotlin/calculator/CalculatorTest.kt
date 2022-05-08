package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith

internal class CalculatorTest : BehaviorSpec({
    val calculator = Calculator()
    var expression: String
    var actual: Int

    given("정상 수식을 입력한다") {
        expression = "2 + 3 * 4 / 2"
        `when`("계산기 파라미터로 넘겨 실행한다") {
            actual = calculator.calculate(expression)
            then("기대값과 같은 결과를 출력한다") {
                actual shouldBe 10
            }
        }
    }

    given("빈 문자열을 입력") {
        expression = ""
        `when`("계산기 파라미터로 넘겨 실행한다") {
            val exception = shouldThrow<IllegalArgumentException> {
                Calculator().calculate(expression)
            }
            then("기대값과 같은 결과를 출력한다") {
                exception.message shouldStartWith "빈 값"
            }
        }
    }
    given("잘못된 식 입력") {
        expression = "2 + 3 * 4 / 2 5"
        `when`("계산기 파라미터로 넘겨 실행한다") {
            val exception = shouldThrow<IllegalArgumentException> {
                Calculator().calculate(expression)
            }
            then("기대값과 같은 결과를 출력한다") {
                exception.message shouldStartWith "잘못"
            }
        }
    }
})
