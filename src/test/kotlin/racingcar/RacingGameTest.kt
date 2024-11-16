package racingcar

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RacingGameTest : StringSpec({
    "시도 횟수 (Round) 만큼 각 자동차의 전진 / 멈춤 행위를 진행시킬 수 있다." {
        val racingGame = RacingGame("good,bad,dino", 2, RandomNumberGenerator())
        repeat(2) { racingGame.play() }

        racingGame.isEnd() shouldBe true
        shouldThrowExactly<IllegalArgumentException> {
            racingGame.play()
        }
    }

    "게임을 진행 중인 자동차들의 이름을 확인할 수 있다." {
        val racingGame = RacingGame("good,bad,dino", 2, RandomNumberGenerator())
        racingGame.extractCarNames() shouldBe listOf("good", "bad", "dino")
    }

    "게임의 상황를 확인할 수 있다." {
        val racingGame =
            RacingGame(
                "good,bad,dino",
                2,
                CustomNumberGenerator(mutableListOf(4, 0, 0, 7, 6, 1)),
            )

        val expectedResults =
            listOf(
                listOf(1, 0, 0),
                listOf(2, 1, 0),
            )

        expectedResults.forEach { expected ->
            racingGame.play()
            racingGame.extractNowCarPositions() shouldBe expected
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
                listOf("good"),
            ),
            row(
                RacingGame(
                    "good,bad,dino",
                    2,
                    CustomNumberGenerator(mutableListOf(4, 1, 3, 2, 3, 7)),
                ),
                2,
                listOf("good", "dino"),
            ),
        ) { game, repeatCount, winner ->
            repeat(repeatCount) { game.play() }
            game.extractWinner() shouldBe winner
        }
    }
})
