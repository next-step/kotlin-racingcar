package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import racing.domain.CarFactory

class CarFactoryKoTest : FreeSpec({
    "createCars" - {
        val name = "BrunoMars"

        "with user name ( $name ) length greater than 5 " - {
            "throws IllegalArgumentException" {
                shouldThrow<IllegalArgumentException> {
                    CarFactory().createCars(listOf(name))
                }
            }
        }

        "with valid car names" - {
            "return car list with input name"
        }
    }
})
