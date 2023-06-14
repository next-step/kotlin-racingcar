package racing_car.domain.race

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racing_car.domain.car.Car
import racing_car.domain.car.CarFactory
import racing_car.domain.car.FixedMovingEngine
import racing_car.domain.car.RandomMovingEngine

class RaceGameTest : StringSpec({
    "주어진 round 숫자만큼 racingGame이 진행된다 " {
        val carList = CarFactory.createCars(listOf("A"), RandomMovingEngine())
        val roundCount = 6

        val racingGame = RaceGame(carList)
        val raceResult = racingGame.execute(roundCount)

        raceResult.roundCount shouldBe roundCount
    }

    "매 Round별 모든 차가 1씩 움직일때, racingGame의 결과가 정상적으로 반환된다 " {
        val car1 = Car("A", FixedMovingEngine(1))
        val car2 = Car("B", FixedMovingEngine(1))

        val raceResult = RaceGame(listOf(car1, car2)).execute(2)

        raceResult.getRoundResult(0).getCarStatus("A").position shouldBe 1
        raceResult.getRoundResult(0).getCarStatus("B").position shouldBe 1

        raceResult.getRoundResult(1).getCarStatus("A").position shouldBe 2
        raceResult.getRoundResult(1).getCarStatus("B").position shouldBe 2
    }

    "매 Round별 각 차가 각자 고정된 값만큼 움직일때, racingGame의 결과가 정상적으로 반환된다 " {
        val car1 = Car("A", FixedMovingEngine(1))
        val car2 = Car("B", FixedMovingEngine(2))

        val raceResult = RaceGame(listOf(car1, car2)).execute(2)

        raceResult.getRoundResult(0).getCarStatus("A").position shouldBe 1
        raceResult.getRoundResult(0).getCarStatus("B").position shouldBe 2

        raceResult.getRoundResult(1).getCarStatus("A").position shouldBe 2
        raceResult.getRoundResult(1).getCarStatus("B").position shouldBe 4
    }

    " Car이 RacingGame으로 전달되지 않는 경우, 예외가 throw 된다" {
        shouldThrow<IllegalArgumentException> {
            RaceGame(listOf())
        }
    }

    "RoundCount가 0인 경우, 예외가 throw 된다" {
        shouldThrow<IllegalArgumentException> {
            val carList = CarFactory.createCars(listOf("A"), FixedMovingEngine(1))
            RaceGame(carList).execute(0)
        }
    }

    "RoundCount가 음수인 경우, 예외가 throw 된다" {
        shouldThrow<IllegalArgumentException> {
            val carList = CarFactory.createCars(listOf("A"), FixedMovingEngine(1))
            RaceGame(carList).execute(-1)
        }
    }
})
