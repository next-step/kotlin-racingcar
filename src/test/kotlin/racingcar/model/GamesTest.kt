package racingcar.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class GamesTest : StringSpec({

    "자동차 갯수와 게임 횟수, 게임 규칙을 받아 게임을 생성 한다" {
        val racingGame = Games.of("pobi,jason", SuccessMovement())

        racingGame.shouldBeInstanceOf<Games>()
    }

    "게임을 진행하면 자동차의 위치가 변경된다" {
        val racingGame = Games.of("pobi,jason", SuccessMovement())
        val result = racingGame.play()

        result[0].position shouldBe 1
    }

    "게임 진행 결과 자동차 경주의 우승자를 반환한다" {
        val racingGame = Games.of("pobi,jason", SuccessMovement())
        racingGame.play()
        val winner = racingGame.getWinner()

        winner.size shouldBeGreaterThan 0
    }
})
