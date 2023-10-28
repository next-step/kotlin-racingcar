package calculator

import calculator.Arithmetic.PLUS
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class ArithmeticTest : BehaviorSpec({
    given("두 숫자가 있다.") {
        val a = Number(6)
        val b = Number(3)
        `when`("더하면") {
            val plus = PLUS.operation(a, b)
            then("결과는 9이다.") {
                plus shouldBe Number(9)
            }
        }
        `when`("빼면") {
            val minus = Arithmetic.MINUS.operation(a, b)
            then("결과는 3이다.") {
                minus shouldBe Number(3)
            }
        }
        `when`("곱하면") {
            val minus = Arithmetic.MULTIPLY.operation(a, b)
            then("결과는 18이다.") {
                minus shouldBe Number(18)
            }
        }
        `when`("나누면") {
            val minus = Arithmetic.DIVIDE.operation(a, b)
            then("결과는 2이다.") {
                minus shouldBe Number(2)
            }
        }
    }
})
