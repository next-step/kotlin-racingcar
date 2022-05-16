package racing

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import racing.domain.CarFactory

class CarFactoryKoTest : FreeSpec({
    "createCars" - {
        "with valid car names" - {
            "return car list with input name" {
                val names = listOf("Andy", "Bruce")

                val racingCars = CarFactory().createCars(names)
                racingCars.map { it.name } shouldContainExactlyInAnyOrder listOf("Andy", "Bruce")
            }
        }
    }
})
