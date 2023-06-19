package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingCar
import racingcar.domain.RacingCarGame

class RacingCarGameTest : StringSpec({

    val racingCarGame = RacingCarGame(listOf(RacingCar("test")))

    "1 ~ 9 까지의 입력 중 4 미만일 경우 차가 전진할 수 없다." {
        racingCarGame.racing { 0 }
        racingCarGame.racingCars[0].position shouldBe 0
    }

    "1 ~ 9 까지의 입력 중 4 이상일 경우 차가 전진한다." {
        forAll(
            row(1),
            row(2),
            row(3),
            row(4),
            row(5),
            row(6),
        ) { position ->
            racingCarGame.racing { 4 }
            racingCarGame.racingCars[0].position shouldBe position
        }
    }

    "자동차 경주의 최종 우승자를 가져온다." {
        val finishedRacingCarGame = RacingCarGame(
            listOf(RacingCar("1등"), RacingCar("2등"))
        )

        finishedRacingCarGame.racing { 0 }

        finishedRacingCarGame.winners() shouldBe "1등, 2등"
    }
})
