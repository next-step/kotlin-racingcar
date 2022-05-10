package racingcar.business

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingcar.utils.RandomGenerator

class RacingContextTest : DescribeSpec({
    describe("play 메서드") {
        context("랜덤 값이 4 이상일 때") {
            class TestRandom : RandomGenerator {
                override fun generateNumberWithin(range: IntRange): Int {
                    return (4..9).random()
                }
            }

            it("모든 자동차는 1 x moveCount 만큼 이동한다.") {
                val expected = listOf(
                    listOf(1, 1),
                    listOf(2, 2)
                )

                val result = RacingContext(2, 2, TestRandom())
                    .play()

                result shouldBe expected
            }
        }

        context("랜덤 값이 3 이하일 때") {
            class TestRandom : RandomGenerator {
                override fun generateNumberWithin(range: IntRange): Int {
                    return (0..3).random()
                }
            }
            it("모든 자동차는 이동하지 않는다.") {
                val expected = listOf(
                    listOf(0, 0),
                    listOf(0, 0)
                )

                val result = RacingContext(2, 2, TestRandom())
                    .play()

                result shouldBe expected
            }
        }
    }
})
