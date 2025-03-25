package racingcar.game

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.ints.shouldBeInRange
import racingcar.car.Car
import racingcar.car.Cars

class RacingGameTest : DescribeSpec({
    describe("create") {
        context("when inputs are valid") {
            it("does not throw exception") {
                this@context.withData(
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
        }
    }

    describe("play") {
        context("when racing game is played") {
            it("all cars should moved only until the number of rounds") {
                listOf(3, 4, 9, 10).forAll { round ->
                    val cars = Cars(listOf(Car("sun"), Car("brie")))
                    val racingGame = RacingGame(cars, Round(round))
                    racingGame.play()

                    cars.values.map { it.position }.forAll { position ->
                        position shouldBeInRange 0..round
                    }
                }
            }

            it("should throw exception if there is no round to proceed") {
                val cars = Cars(listOf(Car("sun"), Car("brie")))
                val racingGame = RacingGame(cars, Round(1))
                racingGame.play()

                shouldThrow<IllegalStateException> {
                    racingGame.play()
                }
            }
        }
    }

    describe("finding winners") {
        context("there is only one winner") {
            it("winning car names contains one name") {
                val racingGame =
                    RacingGame(
                        Cars(
                            listOf(
                                Car("sun", canMove = { true }),
                                Car("brie", canMove = { false }),
                            ),
                        ),
                        Round(3),
                    )

                racingGame.play()

                racingGame.cars.winningCarNames() shouldContainExactly listOf("sun")
            }
        }

        context("there are two winners") {
            it("winning car names contains two names") {
                val racingGame =
                    RacingGame(
                        Cars(
                            listOf(
                                Car("sun", canMove = { true }),
                                Car("brie", canMove = { true }),
                            ),
                        ),
                        Round(3),
                    )

                racingGame.play()

                racingGame.cars.winningCarNames() shouldContainExactly listOf("sun", "brie")
            }
        }
    }
})
