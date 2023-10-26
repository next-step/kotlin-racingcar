package calculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class ExpressionTest : BehaviorSpec({
    given("숫자가 와 수식이 주어짐") {
        var expression = Expression(Number(0))
        `when`("숫자 추가 시") {
            expression = expression.put("1")
            then("숫자가 추가됨") {
                expression.number shouldBe Number(1)
            }
        }
        `when`("덧셈 추가 시") {
            expression = expression.put("+")
            then("덧셈이 추가됨") {
                expression shouldBe Expression(Number(1), Arithmetic.PLUS)
            }
        }
        `when`("다른 숫자 추가 시") {
            expression = expression.put("2")
            then("덧셈이 계산됨") {
                expression shouldBe Expression(Number(3))
            }
        }
    }
})
