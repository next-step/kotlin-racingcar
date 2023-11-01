package racing_car.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe

class RacingGameTest : FunSpec({

    context("입력된 수만큼 자동차를 만든다.") {
        withData(
            nameFn = { "numberOfCars : $it" },
            2, 13, 12, 1000,
        ) { numberOfCars ->

            val racingGame = RacingGame(numberOfCars = numberOfCars, racingRound = 10)

            racingGame.cars.size shouldBe numberOfCars
        }
    }

    context("자동차 대수가 2대 보다 작은 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { "numberOfCars : $it" },
            0, 1, -12, -1000,
        ) { numberOfCars ->

            shouldThrow<IllegalArgumentException> { RacingGame(numberOfCars = numberOfCars, racingRound = 10) }
        }
    }

    context("입력된 수만큼 레이싱을 진행한다.") {
        withData(
            nameFn = { "numberOfMove : $it" },
            1, 13, 12, 30,
        ) { numberOfMove ->

            val racingGame = RacingGame(numberOfCars = 10, racingRound = numberOfMove)

            var actualNumberOfMove = 0
            while (racingGame.isContinuable) {
                racingGame.move()
                actualNumberOfMove++
            }

            actualNumberOfMove shouldBe numberOfMove
        }
    }

    context("시도할 횟수가 1보다 작은 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { "numberOfMove : $it" },
            0, -1, -13, -30,
        ) { numberOfMove ->
            shouldThrow<IllegalArgumentException> { RacingGame(numberOfCars = 10, racingRound = numberOfMove) }
        }
    }

    context("자동차 경주에 포함된 자동차들이 올바르게 이동한다.") {

        // TODO : 개선 필요
        val racingGame = RacingGame(numberOfCars = 10, racingRound = 10)

        for (i in 1..3) {
            racingGame.move()
        }

        racingGame.cars.forEach {
            it.position shouldBeGreaterThan 0
        }
    }
})
