package racingcar

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.datatest.withData
import io.kotest.inspectors.forAll
import io.kotest.matchers.ranges.shouldBeIn
import racingcar.car.Car
import racingcar.car.Cars

class RacingGameTest : ShouldSpec({
    context("Create") {
        withData(
            1 to 3,
            5 to 5,
            1 to 10,
            10 to 10,
        ) { (numberOfCars, numberOfRounds) ->
            shouldNotThrowAny {
                RacingGame(numberOfCars, numberOfRounds)
            }
        }
    }

    context("Race") {
        should("car position be in between 0 to rounds number") {
            listOf(
                3,
                4,
                9,
                10,
            ).forAll { rounds ->
                val car1 = Car()
                val car2 = Car()

                val racingGame =
                    RacingGame(
                        Cars(listOf(car1, car2)),
                        rounds,
                    )

                racingGame.start()

                car1.position shouldBeIn 0..rounds
                car2.position shouldBeIn 0..rounds
            }
        }
    }
})
