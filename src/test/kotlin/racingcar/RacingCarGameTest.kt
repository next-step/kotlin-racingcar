package racingcar

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RacingCarGameTest : DescribeSpec({
    describe("fail") {
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

        describe("create success") {

            it("if valid number of cars, trial") {
                shouldNotThrowAny {
                    RacingCarGame(3, 5)
                }
            }
        }

        TODO("start game with mocked MovePolicy")
    }
}) {
    companion object {
        val zeroOrNegative = listOf(0, -1, 10)
    }
}
