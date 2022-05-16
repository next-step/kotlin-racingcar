package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racing.domain.Car
import racing.domain.CarRacing
import racing.domain.StaticPowerStrategy

private fun TestCar(name: String, position: Int = 0) =
    Car(name = name, powerStrategy = StaticPowerStrategy(power = 10), startPosition = position)

class CarRacingKoTest : DescribeSpec({
    describe("init") {
        context("with move count less than 0 or not number") {
            it("throws IllegalArgumentException") {
                shouldThrow<IllegalArgumentException> {
                    CarRacing(
                        cars = listOf(TestCar("Andy"), TestCar("Bruce")),
                        moveCount = -1
                    )
                }
            }
        }
    }

    describe("run method") {
        context("with moveCount = 2") {
            val moveCount = 2

            it("all cars position and turn count should be 2") {
                val andy = TestCar("Andy")
                val bruce = TestCar("Bruce")

                var turnCount = 0

                CarRacing(
                    cars = listOf(andy, bruce),
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
