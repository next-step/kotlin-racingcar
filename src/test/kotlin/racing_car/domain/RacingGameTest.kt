package racing_car.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class RacingGameTest : FunSpec({

    context("입력된 수만큼 자동차를 만든다.") {
        withData(
            nameFn = { "numberOfCars : $it" },
            2, 13, 12, 1000,
        ) { numberOfCars ->

            val cars = List(numberOfCars) { Car(name = "name") }
            val racingGame = RacingGame(_cars = cars, racingRound = 10)

            racingGame.cars.size shouldBe numberOfCars
        }
    }

    context("자동차 대수가 2대 보다 작은 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { "numberOfCars : $it" },
            0, 1,
        ) { numberOfCars ->
            val cars = List(numberOfCars) { Car(name = "name") }
            shouldThrow<IllegalArgumentException> { RacingGame(_cars = cars, racingRound = 10) }
        }
    }

    context("입력된 수만큼 레이싱을 진행한다.") {
        withData(
            nameFn = { "racingRound : $it" },
            2, 13, 12, 30,
        ) { racingRound ->

            val cars = List(racingRound) { Car(name = "name") }
            val racingGame = RacingGame(_cars = cars, racingRound = racingRound)

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
            nameFn = { "racingRound : $racingRound, actualMove : $it" },
            6, 10,
        ) { actualMove ->

            val cars = List(10) { Car(name = "name") }
            val racingGame = RacingGame(_cars = cars, racingRound = racingRound)

            shouldThrow<IllegalStateException> {
                for (i in 1..actualMove) {
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
                RacingGame(_cars = cars, racingRound = racingRound)
            }
        }
    }

    context("자동차 경주에 포함된 자동차들이 올바르게 이동한다.") {

        val racingRound = 10
        val cars = List(10) { Car(name = "name", moveStrategy = alwaysMoveStrategy) }
        val racingGame = RacingGame(_cars = cars, racingRound = racingRound)

        for (i in 1..racingRound) {
            racingGame.move()
            racingGame.cars.forEach {
                it.position shouldBe i
            }
        }
    }

    context("부정행위가 통하지 않는다.(racingGame 외부에서 자동차를 변경시키지 못한다.") {
        val actualMove = 5
        val racingGame = RacingGame(
            _cars = List(10) { Car(name = "name", moveStrategy = alwaysMoveStrategy) },
            racingRound = 10
        )
        for (i in 1..actualMove) {
            racingGame.move()
        }

        // 부정행위!!!
        racingGame.cars.forEach {
            it.move()
            it.move()
        }

        racingGame.cars.forAll {
            it.position shouldBe actualMove
        }
    }
}) {
    companion object {
        val alwaysMoveStrategy = MoveStrategy { true }
    }
}
