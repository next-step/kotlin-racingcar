package racing

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import racing.domain.CarFactory

class CarFactoryKoTest : FreeSpec({
    "createCars" - {
        "with valid car names" - {
            "return car list with input name" {
                val names = listOf("Andy", "Bruce")

                val racingCars = CarFactory().createCars(names)

                names.forEachIndexed { index, name ->
                    racingCars.cars[index].name shouldBe name
                }
            }
        }
    }
})
