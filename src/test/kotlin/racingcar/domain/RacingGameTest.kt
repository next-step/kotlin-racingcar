package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe
import racingcar.CustomNumberGenerator
import racingcar.domain.vo.CarName
import racingcar.domain.vo.CarPosition
import racingcar.infrastructure.RandomNumberGenerator

class RacingGameTest : StringSpec({
    "시도 횟수 (Round) 만큼 각 자동차의 전진 / 멈춤 행위를 진행시킬 수 있다." {
        val racingGame = RacingGame("good,bad,dino", 2, RandomNumberGenerator())
        repeat(2) { racingGame.play() }

        racingGame.isEnd() shouldBe true
        shouldThrowExactly<IllegalArgumentException> {
            racingGame.play()
        }
    }

    "게임의 우승자에 대한 정보를 반환할 수 있다." {
        forAll(
            row(
                RacingGame(
                    "good,bad,dino",
                    2,
                    CustomNumberGenerator(mutableListOf(4, 0, 0, 7, 6, 1)),
                ),
                2,
                Cars(listOf(Car(CarName("good"), CarPosition(2)))),
            ),
            row(
                RacingGame(
                    "good,bad,dino",
                    2,
                    CustomNumberGenerator(mutableListOf(4, 1, 3, 2, 3, 7)),
                ),
                2,
                Cars(
                    listOf(
                        Car(CarName("good"), CarPosition(2)),
                        Car(CarName("dino"), CarPosition(2)),
                    ),
                ),
            ),
        ) { game, repeatCount, winner ->
            repeat(repeatCount) { game.play() }
            game.getWinners() shouldBeEqualToComparingFields winner
        }
    }
})
