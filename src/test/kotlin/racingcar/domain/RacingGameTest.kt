package racingcar.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import racingcar.domain.vo.Round

internal class RacingGameTest : FunSpec({

    context("객체 생성") {
        test("자동차 이름, 라운드를 입력받아 게임 객체를 생성한다.") {
            shouldNotThrowAny {
                RacingGame(listOf("name1", "name2"), 1)
            }
        }

        test("자동차 대수가 2대 미만일 경우, IllegalArgumentException이 발생한다.") {
            val actual = shouldThrow<IllegalArgumentException> {
                RacingGame(listOf("name1"), 1)
            }

            actual.message shouldBe "at least 2 cars are needed to play"
        }

        test("시도 횟수가 1 미만일 경우, IllegalArgumentException이 발생한다.") {
            val actual = shouldThrow<IllegalArgumentException> {
                RacingGame(listOf("name1", "name2"), 0)
            }

            actual.message shouldBe "at least 1 round is needed to play"
        }
    }

    context("playNextRound()") {
        test("게임에 참여한 자동차들이 경주한다.") {
            val racingGame = RacingGame(listOf("name1", "name2"), 1)
            val carPositions = racingGame.playNextRound { true }

            carPositions.forAll {
                it.position shouldBe 1
            }

            racingGame.hasNextRound() shouldBe false
        }
    }

    context("hasNextRound()") {
        test("시도 횟수가 1 이상일 경우, 참을 반환한다.") {
            val actual = RacingGame(listOf("name1", "name2"), 1).hasNextRound()

            actual shouldBe true
        }

        test("시도 횟수가 1 미만일 경우, 거짓을 반환한다.") {
            val racingGame = RacingGame(listOf("name1", "name2"), 1)
            racingGame.playNextRound { true }
            val actual = racingGame.hasNextRound()

            actual shouldBe false
        }
    }

    context("findWinnerNames()") {
        test("우승자들을 반환한다.") {
            val winner1 = Car("win1", 2)
            val winner2 = Car("win2", 2)
            val racingGame = RacingGame(listOf(winner1, winner2, Car("lose1", 1)), Round(1))
            val winners = racingGame.findWinners()

            winners.size shouldBe 2
            winners[0].name() shouldBe winner1.name
            winners[1].name() shouldBe winner2.name
        }
    }
})
