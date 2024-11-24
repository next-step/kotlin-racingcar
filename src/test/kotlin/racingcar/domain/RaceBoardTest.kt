package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.RaceResultPerRound.Companion.fromCars

class RaceBoardTest : StringSpec({
    "findWinners() 는 포지션이 가장 높은 차를 반환한다" {
        val car1 = Car(name = "Car1", position = 3)
        val car2 = Car(name = "Car2", position = 5)
        val raceBoard = RaceBoard(listOf(fromCars(listOf(car1, car2))))

        raceBoard.findWinners().size shouldBe 1
        raceBoard.findWinners().first().name shouldBe "Car2"
    }

    "findWinners() 는 포지션이 가장 높은 차가 여러대라면 해당 차를 모두 반환한다" {
        val car1 = Car(name = "Car1", position = 5)
        val car2 = Car(name = "Car2", position = 5)
        val raceBoard = RaceBoard(listOf(fromCars(listOf(car1, car2))))

        raceBoard.findWinners().size shouldBe 2
    }
})
