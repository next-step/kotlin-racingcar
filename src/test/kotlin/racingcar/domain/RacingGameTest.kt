package racingcar.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class RacingGameTest : FunSpec({

    context("객체 생성") {
        test("게임 객체를 생성한다.") {
            shouldNotThrowAny {
                RacingGame(2, 1)
            }
        }

        test("자동차 대수가 2대 미만일 경우, IllegalArgumentException이 발생한다.") {
            val actual = shouldThrow<IllegalArgumentException> {
                RacingGame(1, 1)
            }

            actual.message shouldBe "at least 2 cars are needed to play"
        }

        test("시도 횟수가 1 미만일 경우, IllegalArgumentException이 발생한다.") {
            val actual = shouldThrow<IllegalArgumentException> {
                RacingGame(2, 0)
            }

            actual.message shouldBe "at least 1 round is needed to play"
        }
    }

    context("playNextRound()") {
        test("게임에 참여한 자동차들이 경주한다.") {
            val racingGame = RacingGame(2, 1)
            racingGame.playNextRound { true }

            with(racingGame) {
                cars.forAll {
                    it.position shouldBe Position(1)
                }

                hasNextRound() shouldBe false
            }
        }
    }

    context("hasNextRound()") {
        test("시도 횟수가 1 이상일 경우, 참을 반환한다.") {
            val actual = RacingGame(2, 1).hasNextRound()

            actual shouldBe true
        }

        test("시도 횟수가 1 미만일 경우, 거짓을 반환한다.") {
            val racingGame = RacingGame(2, 1)
            racingGame.playNextRound { true }
            val actual = racingGame.hasNextRound()

            actual shouldBe false
        }
    }
})
