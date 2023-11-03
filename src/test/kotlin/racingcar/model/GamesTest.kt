package racingcar.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class GamesTest : StringSpec({

    "자동차 리스트 정보를 받아 게임을 생성 한다" {
        val pobi = Car("pobi", 0, SuccessMovement())
        val racingGame = Games(Cars(listOf(pobi)))

        racingGame.shouldBeInstanceOf<Games>()
    }

    "게임을 진행하면 자동차의 위치가 변경된다" {
        val pobi = Car("pobi", 0, SuccessMovement())
        val racingGame = Games(Cars(listOf(pobi)))
        racingGame.play()

        pobi.position shouldBe 1
    }

    "게임 진행 결과 자동차 경주의 우승자를 반환한다" {
        val pobi = Car("pobi", 0, SuccessMovement())
        val jason = Car("jason", 0, FailMovement())
        val racingGame = Games(Cars(listOf(pobi, jason)))
        racingGame.play()

        racingGame.getWinner() shouldBe listOf(pobi)
    }
})
