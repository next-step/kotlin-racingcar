package racingcar

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.datatest.withData
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.ranges.shouldBeIn
import racingcar.car.Car
import racingcar.car.Cars

class RacingGameTest : ShouldSpec({
    context("Create") {
        withData(
            listOf("sun", "brie") to 3,
            listOf("sun", "brie", "1", "2", "3") to 5,
            listOf("sun") to 10,
            listOf("sun", "brie", "1", "2", "3") to 10,
        ) { (carNames, numberOfRounds) ->
            shouldNotThrowAny {
                RacingGame(carNames, numberOfRounds)
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
                val car1 = Car("sun")
                val car2 = Car("brie")

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

    context("Winners") {
        should("get winners") {
            val racingGame =
                RacingGame(
                    Cars(
                        listOf(
                            Car("sun", canMove = { true }),
                            Car("brie", canMove = { false }),
                        ),
                    ),
                    3,
                )

            racingGame.start()
            racingGame.winningCarNames shouldContainExactly listOf("sun")
        }
    }
})
