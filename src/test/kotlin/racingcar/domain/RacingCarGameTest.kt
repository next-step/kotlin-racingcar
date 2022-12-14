package racingcar.domain

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe

class RacingCarGameTest : DescribeSpec({
    describe("create RacingCarGame fail") {
        it("if car names is empty") {
            val ex = shouldThrow<IllegalArgumentException> { RacingCarGame(listOf(), 10) }
            ex.message shouldBe "자동차 대수는 1대 이상이여야 합니다"
        }
        it("if number of trial is zero or negative") {
            listOf(0, -1, -10).forEach {
                val ex = shouldThrow<IllegalArgumentException> { RacingCarGame(listOf("test"), it) }
                ex.message shouldBe "시도 횟수는 1회 이상이여야 합니다"
            }
        }

        describe("create RacingCarGame success") {

            it("if valid car names, trial") {
                shouldNotThrowAny {
                    RacingCarGame(listOf("test1", "test2"), 5)
                }
            }
        }

        describe("start game success") {
            it("if number of car : 1, number of trial : 2") {
                val result = RacingCarGame(listOf("test"), 2, FixedNumberProvider(9)).startGame()

                assertSoftly(result) {
                    it.snapShots.size shouldBe 2
                    it.snapShots.shouldContainExactly(
                        RacingCarGameSnapShot(listOf(CarSnapShot("test", 1))),
                        RacingCarGameSnapShot(listOf(CarSnapShot("test", 2)))
                    )
                    it.getWinnersOfGame() shouldContainExactly listOf("test")
                }
            }

            it("if number of car : 2, number of trial : 1") {
                val result = RacingCarGame(listOf("test1", "test2"), 1, FixedNumberProvider(1)).startGame()
                assertSoftly(result) {
                    it.snapShots.size shouldBe 1
                    it.snapShots.shouldContainExactly(
                        RacingCarGameSnapShot(listOf(CarSnapShot("test1", 0), CarSnapShot("test2", 0)))
                    )

                    it.getWinnersOfGame() shouldContainExactlyInAnyOrder listOf("test1", "test2")
                }
            }
        }
    }
}) {
    companion object {
        class FixedNumberProvider(private val fixedNumber: Int) : ConditionProvider {
            override fun nextCondition(): Int {
                return fixedNumber
            }
        }
    }
}
