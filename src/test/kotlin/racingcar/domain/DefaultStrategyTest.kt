package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class DefaultStrategyTest : DescribeSpec({

    describe("isMovable") {
        context("숫자가 4 이상이면") {
            listOf(4, 5, 6, 7, 8, 9).forAll {
                val strategy = DefaultStrategy { _: Int, _: Int -> it }
                strategy.isMovable() shouldBe true
            }
        }

        context("숫자가 4 미만이면") {
            it("false 를 반환한다") {
                listOf(0, 1, 2, 3).forAll {
                    val strategy = DefaultStrategy { _: Int, _: Int -> it }
                    strategy.isMovable() shouldBe false
                }
            }
        }
    }
})
