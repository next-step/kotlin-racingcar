package racingcar.business

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.GameResult
import racingcar.domain.Record
import racingcar.domain.collection.RoundRecord
import racingcar.utils.NumberGenerator
import racingcar.utils.RandomNumberGenerator

class RacingContextTest : DescribeSpec({
    describe("play 메서드") {
        context("랜덤 값이 4 이상일 때") {
            class TestRandomNumberGenerator : NumberGenerator {
                override fun executeRangeOf(range: IntRange): Int {
                    return (4..9).random()
                }
            }

            it("모든 자동차는 1 x moveCount 만큼 이동하고 모두 우승자이다.") {
                val expectedGameRecord = GameResult(
                    listOf(
                        RoundRecord(
                            listOf(
                                Record("car1", 1),
                                Record("car2", 1),
                                Record("car3", 1)
                            )
                        ),
                        RoundRecord(
                            listOf(
                                Record("car1", 2),
                                Record("car2", 2),
                                Record("car3", 2)
                            )
                        )
                    )
                )

                val expectedWinner = listOf("car1", "car2", "car3")

                val result = RacingGame(listOf("car1", "car2", "car3"), 2, TestRandomNumberGenerator())
                    .play()

                result.records shouldBe expectedGameRecord.records
                result.winners shouldBe expectedWinner
            }
        }

        context("랜덤 값이 3 이하일 때") {
            class TestRandomNumberGenerator : NumberGenerator {
                override fun executeRangeOf(range: IntRange): Int {
                    return (0..3).random()
                }
            }
            it("모든 자동차는 이동하지 않고, 모두 우승자이다.") {
                val expectedGameRecord = GameResult(
                    listOf(
                        RoundRecord(
                            listOf(
                                Record("car1", 0),
                                Record("car2", 0),
                                Record("car3", 0)
                            )
                        ),
                        RoundRecord(
                            listOf(
                                Record("car1", 0),
                                Record("car2", 0),
                                Record("car3", 0)
                            )
                        )
                    )
                )

                val expectedWinner = listOf("car1", "car2", "car3")

                val result = RacingGame(listOf("car1", "car2", "car3"), 2, TestRandomNumberGenerator())
                    .play()

                result.records shouldBe expectedGameRecord.records
                result.winners shouldBe expectedWinner
            }
        }
    }

    describe("init 메서드") {

        val random: NumberGenerator = RandomNumberGenerator()

        context("플레이어가 0 명 일 때") {
            it("예외를 던진다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    RacingGame(listOf(), 1, random)
                }
                exception.message shouldBe "플레이어는 조건은 최소 1명 이상입니다."
            }
        }

        context("플레이어가 1 명 이상 일 때") {
            it("객체 생성을 한다.") {
                RacingGame(listOf("car1"), 1, random)
                RacingGame(listOf("car1", "car2"), 1, random)
            }
        }

        context("이동 횟수가 0 명 일 때") {
            it("예외를 던진다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    RacingGame(listOf("car1"), 0, random)
                }
                exception.message shouldBe "이동 횟수 조건은 최소 1번 이상입니다."
            }
        }

        context("이동 횟수가 1 명 이상 일 때") {
            it("객체 생성을 한다.") {
                RacingGame(listOf("car1"), 1, random)
                RacingGame(listOf("car1"), 2, random)
            }
        }
    }
})
