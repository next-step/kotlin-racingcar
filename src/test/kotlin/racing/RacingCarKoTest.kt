package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import racing.domain.Car
import racing.domain.RacingCars
import racing.domain.StaticPowerStrategy

private fun testCar(name: String, position: Int = 0) =
    Car(name = name, powerStrategy = StaticPowerStrategy(power = 10), startPosition = position)

class RacingCarKoTest : FreeSpec({

    "init" - {
        "when car name length greater than 5" - {
            "throws IllegalArgumentException" {
                val andy = testCar("Andy")
                val bruce = testCar("BrunoMars")

                shouldThrow<IllegalArgumentException> {
                    RacingCars(listOf(andy, bruce))
                }
            }
        }
    }
    "moveAll" - {
        val andy = testCar("Andy", 2)
        val bruce = testCar("Bruce", 1)

        val racingCars = RacingCars(listOf(andy, bruce))

        "when called method with racing cars $racingCars" - {
            "should move all cars" {
                racingCars.moveAll()

                andy.position shouldBe 3
                bruce.position shouldBe 2
            }
        }
    }

    "findWinners" - {
        val andy = testCar("Andy", 2)
        val bruce = testCar("Bruce", 1)
        val clara = testCar("Bruce", 2)

        val racingCars = RacingCars(listOf(andy, bruce, clara))

        "with racingCars $racingCars" - {
            "should return list of winners" {
                val winners = racingCars.findWinners()

                winners.cars shouldBe listOf(andy, clara)
            }
        }
    }
})
