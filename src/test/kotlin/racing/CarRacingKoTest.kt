package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racing.domain.Car
import racing.domain.CarRacing
import racing.domain.StaticPowerStrategy

private fun testCar(name: String, position: Int = 0) =
    Car(name = name, powerStrategy = StaticPowerStrategy(power = 10), startPosition = position)

class CarRacingKoTest : DescribeSpec({
    describe("run method") {

        context("with move count less than 0 or not number") {
            it("throws IllegalArgumentException") {
                shouldThrow<IllegalArgumentException> {
                    CarRacing.run(
                        cars = listOf(testCar("Andy"), testCar("Bruce")),
                        moveCount = -1
                    )
                }
            }
        }

        context("with moveCount = 2") {
            val moveCount = 2

            it("all cars position and turn count should be 2") {
                val andy = testCar("Andy")
                val bruce = testCar("Bruce")

                var turnCount = 0

                CarRacing.run(
                    cars = listOf(andy, bruce),
                    moveCount = 2,
                    onTurnEnd = { turnCount++ }
                )

                turnCount shouldBe moveCount
                andy.position shouldBe moveCount
                bruce.position shouldBe moveCount
            }
        }

        context("when finish move count") {
            it("called onFinish with winners ( winner is car with highest position )") {
                val andy = testCar("Andy", 2)
                val bruce = testCar("Bruce", 1)

                var winners: List<Car> = listOf()

                CarRacing.run(
                    cars = listOf(andy, bruce),
                    moveCount = 0,
                    onFinish = {
                        winners = it
                    }
                )

                winners shouldBe listOf(andy)
            }
        }
    }
})
