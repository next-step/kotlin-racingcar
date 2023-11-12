package racing_car.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class RacingGameTest : FunSpec({

    context("입력된 수만큼 자동차를 만든다.") {
        withData(
            nameFn = { "numberOfCars : $it" },
            2, 13, 12, 1000,
        ) { numberOfCars ->

            val cars = List(numberOfCars) { Car(name = "name") }
            val racingGame = RacingGame(cars = cars, racingRound = 10)

            racingGame.getCarList().size shouldBe numberOfCars
        }
    }

    context("자동차 대수가 2대 보다 작은 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { "numberOfCars : $it" },
            0, 1,
        ) { numberOfCars ->
            val cars = List(numberOfCars) { Car(name = "name") }
            shouldThrow<IllegalArgumentException> { RacingGame(cars = cars, racingRound = 10) }
        }
    }

    context("입력된 수만큼 레이싱을 진행한다.") {
        withData(
            nameFn = { "racingRound : $it" },
            2, 13, 12, 30,
        ) { racingRound ->

            val cars = List(racingRound) { Car(name = "name") }
            val racingGame = RacingGame(cars = cars, racingRound = racingRound)

            var actualRacingRound = 0
            while (racingGame.isContinuable) {
                racingGame.move()
                actualRacingRound++
            }

            actualRacingRound shouldBe racingRound
        }
    }

    context("주어진 시도횟수보다 더 많이 시도하는 경우 IllegalStateException throw") {
        val racingRound = 5
        withData(
            nameFn = { "racingRound : $racingRound, actualRound : $it" },
            6, 10,
        ) { actualRound ->

            val cars = List(10) { Car(name = "name") }
            val racingGame = RacingGame(cars = cars, racingRound = racingRound)

            shouldThrow<IllegalStateException> {
                for (i in 1..actualRound) {
                    racingGame.move()
                }
            }
        }
    }

    context("시도할 횟수가 1보다 작은 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { "racingRound : $it" },
            0, -1, -13, -30,
        ) { racingRound ->
            shouldThrow<IllegalArgumentException> {
                val cars = List(10) { Car(name = "name") }
                RacingGame(cars = cars, racingRound = racingRound)
            }
        }
    }

    context("자동차 경주에 포함된 자동차들이 올바르게 이동한다.") {

        val racingRound = 10
        val cars = List(10) { Car(name = "name", moveStrategy = alwaysMoveStrategy) }
        val racingGame = RacingGame(cars = cars, racingRound = racingRound)

        for (i in 1..racingRound) {
            racingGame.move()
            racingGame.getCarList().forEach {
                it.position shouldBe i
            }
        }
    }

    context("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.") {
        val cars = listOf(
            Car(name = "w1", moveStrategy = alwaysMoveStrategy),
            Car(name = "w2", moveStrategy = alwaysMoveStrategy),
            Car(name = "l1", moveStrategy = neverMoveStrategy),
            Car(name = "l2", moveStrategy = neverMoveStrategy),
            Car(name = "l3", moveStrategy = neverMoveStrategy),
        )
        val racingGame = RacingGame(
            cars = cars,
            racingRound = 10,
        )

        while (racingGame.isContinuable) {
            racingGame.move()
        }

        val winners = racingGame.judgeWinners()
        winners.map(Car::name) shouldBe listOf("w1", "w2")
    }

    context("자동차 경주가 끝나기 전에 우승자를 확인하는 경우 IllegalStateException throw") {
        val cars = listOf(
            Car(name = "w1", moveStrategy = alwaysMoveStrategy),
            Car(name = "w2", moveStrategy = alwaysMoveStrategy),
            Car(name = "l1", moveStrategy = neverMoveStrategy),
            Car(name = "l2", moveStrategy = neverMoveStrategy),
            Car(name = "l3", moveStrategy = neverMoveStrategy),
        )
        val racingGame = RacingGame(
            cars = cars,
            racingRound = 10,
        )

        racingGame.move()

        shouldThrow<IllegalStateException> { racingGame.judgeWinners() }
    }
}) {
    companion object {
        val alwaysMoveStrategy = MoveStrategy { true }
        val neverMoveStrategy = MoveStrategy { false }
    }
}
