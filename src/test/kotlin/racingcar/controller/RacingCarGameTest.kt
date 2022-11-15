package racingcar.controller

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RacingCarGameTest : DescribeSpec({
    describe("create RacingCarGame fail") {
        it("if number of cars is zero or negative") {
            zeroOrNegative.forEach {
                val ex = shouldThrow<IllegalArgumentException> { RacingCarGame(it, 10) }
                ex.message shouldBe "자동차 대수는 1대 이상이여야 합니다"
            }
        }
        it("if number of trial is zero or negative") {
            zeroOrNegative.forEach {
                val ex = shouldThrow<IllegalArgumentException> { RacingCarGame(10, it) }
                ex.message shouldBe "시도 횟수는 1회 이상이여야 합니다"
            }
        }

        describe("create RacingCarGame success") {

            it("if valid number of cars, trial") {
                shouldNotThrowAny {
                    RacingCarGame(3, 5)
                }
            }
        }

        describe("start game success") {
            it("if number of car : 1, number of trial : 3") {
                val result = RacingCarGame(1, 3, FixedNumberProvider(9)).startGame()

                assertSoftly(result) {
                    it.getPositions(1) shouldBe listOf(1)
                    it.getPositions(2) shouldBe listOf(2)
                    it.getPositions(3) shouldBe listOf(3)
                }
            }
            it("if number of car : 1, number of trial : 1") {
                val result = RacingCarGame(1, 1, FixedNumberProvider(1)).startGame()
                result.getPositions(1) shouldBe listOf(0)
            }

            it("if number of car : 2, number of trial : 5") {
                val result = RacingCarGame(2, 5, FixedNumberProvider(9)).startGame()

                assertSoftly(result) {
                    it.getPositions(1) shouldBe listOf(1, 1)
                    it.getPositions(2) shouldBe listOf(2, 2)
                    it.getPositions(3) shouldBe listOf(3, 3)
                    it.getPositions(4) shouldBe listOf(4, 4)
                    it.getPositions(5) shouldBe listOf(5, 5)
                }
            }
        }
    }
}) {
    companion object {
        val zeroOrNegative = listOf(0, -1, -10)

        class FixedNumberProvider(private val fixedNumber: Int) : ConditionProvider {
            override fun nextCondition(): Int {
                return fixedNumber
            }
        }
    }
}
