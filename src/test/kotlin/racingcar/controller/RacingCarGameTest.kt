package racingcar.controller

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingcar.controller.policy.MovePolicy

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
                val result = RacingCarGame(1, 3, FixedMovePolicy(5)).startGame()

                assertSoftly(result) {
                    it.getPositions(1) shouldBe listOf(5)
                    it.getPositions(2) shouldBe listOf(10)
                    it.getPositions(3) shouldBe listOf(15)
                }
            }
            it("if number of car : 2, number of trial : 5") {
                val result = RacingCarGame(2, 5, FixedMovePolicy(5)).startGame()

                assertSoftly(result) {
                    it.getPositions(1) shouldBe listOf(5, 5)
                    it.getPositions(2) shouldBe listOf(10, 10)
                    it.getPositions(3) shouldBe listOf(15, 15)
                    it.getPositions(4) shouldBe listOf(20, 20)
                    it.getPositions(5) shouldBe listOf(25, 25)
                }
            }
        }
    }
}) {
    companion object {
        val zeroOrNegative = listOf(0, -1, -10)

        class FixedMovePolicy(private val fixedMovement: Int) : MovePolicy {
            override fun decide(): Int {
                return fixedMovement
            }
        }
    }
}
