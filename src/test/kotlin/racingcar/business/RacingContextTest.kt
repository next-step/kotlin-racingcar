package racingcar.business

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingcar.business.dto.GameResult
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

            it("모든 자동차는 1 x moveCount 만큼 이동한다.") {
                val expected = GameResult(
                    listOf(
                        listOf(1, 1),
                        listOf(2, 2)
                    )
                )

                val result = RacingGame(2, 2, TestRandomNumberGenerator())
                    .play()

                result shouldBe expected
            }
        }

        context("랜덤 값이 3 이하일 때") {
            class TestRandomNumberGenerator : NumberGenerator {
                override fun executeRangeOf(range: IntRange): Int {
                    return (0..3).random()
                }
            }
            it("모든 자동차는 이동하지 않는다.") {
                val expected = GameResult(
                    listOf(
                        listOf(0, 0),
                        listOf(0, 0)
                    )
                )

                val result = RacingGame(2, 2, TestRandomNumberGenerator())
                    .play()

                result shouldBe expected
            }
        }
    }

    describe("init 메서드") {

        val random: NumberGenerator = RandomNumberGenerator()

        context("플레이어가 0 명 일 때") {
            it("예외를 던진다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    RacingGame(0, 1, random)
                }
                exception.message shouldBe "플레이어는 조건은 최소 1명 이상입니다."
            }
        }

        context("플레이어가 1 명 이상 일 때") {
            it("객체 생성을 한다.") {
                RacingGame(1, 1, random)
                RacingGame(1, 1, random)
            }
        }

        context("이동 횟수가 0 명 일 때") {
            it("예외를 던진다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    RacingGame(1, 0, random)
                }
                exception.message shouldBe "이동 횟수 조건은 최소 1번 이상입니다."
            }
        }

        context("이동 횟수가 1 명 이상 일 때") {
            it("객체 생성을 한다.") {
                RacingGame(1, 1, random)
                RacingGame(1, 2, random)
            }
        }
    }
})
