package calculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class ExpressionTest : BehaviorSpec({
    given("숫자가 와 수식이 주어짐") {
        val expression = Expression(Number(0))
        `when`("숫자 추가 시") {
            val addOne = expression.put("1")
            then("숫자가 추가됨") {
                addOne.number shouldBe Number(1)
            }
        }
        `when`("덧셈 추가 시") {
            val addPlus = expression.put("1")
                .put("+")
            then("덧셈이 추가됨") {
                addPlus shouldBe Expression(Number(1), Arithmetic.PLUS)
            }
        }
        `when`("다른 숫자 추가 시") {
            val addTwo = expression.put("1")
                .put("+")
                .put("2")
            then("덧셈이 계산됨") {
                addTwo shouldBe Expression(Number(3))
            }
        }
    }
})
