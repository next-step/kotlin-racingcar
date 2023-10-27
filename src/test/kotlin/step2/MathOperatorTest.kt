package step2

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MathOperatorTest : BehaviorSpec({

    Given("2개의 수가 주어졌을 때") {
        val x = 6
        val y = 2
        When("각 symbol에 맞는 연산을 수행하면") {
            Then("결과값이 반환된다.") {
                forAll(
                    row("+", 8),
                    row("-", 4),
                    row("*", 12),
                    row("/", 3)
                ) { symbol, expected ->
                    MathOperator.from(symbol)?.calculate(x, y) shouldBe expected
                }
            }
        }
    }
})
