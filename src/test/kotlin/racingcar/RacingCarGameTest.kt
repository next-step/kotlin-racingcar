package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingCar
import racingcar.domain.RacingCarGame

class RacingCarGameTest : StringSpec({

    "1 ~ 9 까지의 입력 중 4 미만일 경우 차가 전진할 수 없다." {
        val racingCarGame = RacingCarGame(listOf(RacingCar("test") { 0 }))
        racingCarGame.racing()
        racingCarGame.racingCars[0].position shouldBe 0
    }

    "1 ~ 9 까지의 입력 중 4 이상일 경우 차가 전진한다." {
        val racingCarGame = RacingCarGame(listOf(RacingCar("test") { 4 }))

        forAll(
            row(1),
            row(2),
            row(3),
            row(4),
            row(5),
            row(6),
        ) { position ->
            racingCarGame.racing()
            racingCarGame.racingCars[0].position shouldBe position
        }
    }

    "1 ~ 9 까지의 입력 중 4 미만일 경우 차가 전진할 수 없다.(from을 통하여 생성한 RacingCar)" {
        val racingCarGame = RacingCarGame.from("test") { 0 }
        racingCarGame.racing()
        racingCarGame.racingCars[0].position shouldBe 0
    }

    "1 ~ 9 까지의 입력 중 4 이상일 경우 차가 전진한다.(from을 통하여 생성한 RacingCar)" {
        val racingCarGame = RacingCarGame.from("test") { 9 }
        racingCarGame.racing()
        racingCarGame.racingCars[0].position shouldBe 1
    }

    "자동차 경주의 최종 우승자를 가져온다." {
        val finishedRacingCarGame = RacingCarGame(
            listOf(RacingCar("1등") { 0 }, RacingCar("2등") { 0 })
        )

        finishedRacingCarGame.racing()

        finishedRacingCarGame.winners() shouldBe "1등, 2등"
    }
})
