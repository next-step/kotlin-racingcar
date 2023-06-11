package step3.domain.race

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import step3.domain.car.CarFactory
import step3.domain.car.FixedMovePointDecider
import step3.domain.car.RandomMovePointDecider

class RaceGameTest : StringSpec({
    "주어진 round 숫자만큼 racingGame이 진행된다 " {
        val carList = CarFactory.createCars(5, RandomMovePointDecider())
        val roundCount = 6

        val racingGame = RaceGame(carList)
        val raceResult = racingGame.execute(roundCount)

        raceResult.getRoundCount() shouldBe roundCount
    }

    "매 Round별 모든 차가 1씩 움직일때, racingGame의 결과가 정상적으로 반환된다 " {
        val carList = CarFactory.createCars(2, FixedMovePointDecider(1))

        val racingGame = RaceGame(carList)
        val raceResult = racingGame.execute(2)

        raceResult.getRoundResult(0).getCarStatus(0).position shouldBe 1
        raceResult.getRoundResult(0).getCarStatus(1).position shouldBe 1

        raceResult.getRoundResult(1).getCarStatus(0).position shouldBe 2
        raceResult.getRoundResult(1).getCarStatus(1).position shouldBe 2
    }

    "매 Round별 각 차가 각자 고정된 값만큼 움직일때, racingGame의 결과가 정상적으로 반환된다 " {
        val carList1 = CarFactory.createCars(1, FixedMovePointDecider(1))
        val carList2 = CarFactory.createCars(1, FixedMovePointDecider(2))

        val racingGame = RaceGame(carList1 + carList2)
        val raceResult = racingGame.execute(2)

        raceResult.getRoundResult(0).getCarStatus(0).position shouldBe 1
        raceResult.getRoundResult(0).getCarStatus(1).position shouldBe 2

        raceResult.getRoundResult(1).getCarStatus(0).position shouldBe 2
        raceResult.getRoundResult(1).getCarStatus(1).position shouldBe 4
    }

    " Car이 RacingGame으로 전달되지 않는 경우, 예외가 throw 된다" {
        shouldThrow<IllegalArgumentException> {
            RaceGame(listOf())
        }
    }

    "RoundCount가 0인 경우, 예외가 throw 된다" {
        shouldThrow<IllegalArgumentException> {
            val carList = CarFactory.createCars(1, FixedMovePointDecider(1))
            RaceGame(carList).execute(0)
        }
    }

    "RoundCount가 음수인 경우, 예외가 throw 된다" {
        shouldThrow<IllegalArgumentException> {
            val carList = CarFactory.createCars(1, FixedMovePointDecider(1))
            RaceGame(carList).execute(-1)
        }
    }
})
