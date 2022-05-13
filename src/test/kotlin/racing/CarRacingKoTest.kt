package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racing.domain.Car
import racing.domain.CarRacing
import racing.domain.RacingCars
import racing.domain.StaticPowerStrategy

private fun testCar(name: String, position: Int = 0) =
    Car(name = name, powerStrategy = StaticPowerStrategy(power = 10), startPosition = position)

class CarRacingKoTest : DescribeSpec({
    describe("run method") {

        context("with move count less than 0 or not number") {
            it("throws IllegalArgumentException") {
                shouldThrow<IllegalArgumentException> {
                    CarRacing(
                        cars = RacingCars(listOf(testCar("Andy"), testCar("Bruce"))),
                        moveCount = -1
                    ).run()
                }
            }
        }

        context("with moveCount = 2") {
            val moveCount = 2

            it("all cars position and turn count should be 2") {
                val andy = testCar("Andy")
                val bruce = testCar("Bruce")

                var turnCount = 0

                CarRacing(
                    cars = RacingCars(listOf(andy, bruce)),
                    moveCount = 2
                ).run(
                    onTurnEnd = { turnCount++ }
                )

                turnCount shouldBe moveCount
                andy.position shouldBe moveCount
                bruce.position shouldBe moveCount
            }
        }
    }
})
