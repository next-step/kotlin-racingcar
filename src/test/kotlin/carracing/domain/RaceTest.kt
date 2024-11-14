package carracing.domain

import carracing.util.alwaysMoveGenerator
import carracing.util.neverMoveGenerator
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RaceTest : StringSpec({

    lateinit var cars: List<Car>

    beforeTest {
        cars = List(3) { Car() }
    }

    "start should move cars" {
        val race = Race(cars, 5, alwaysMoveGenerator())
        race.start()

        cars.forEach { car ->
            car.position shouldBe 5
        }
    }

    "start should not move cars" {
        val race = Race(cars, 5, neverMoveGenerator())
        race.start()

        cars.forEach { car ->
            car.position shouldBe 0
        }
    }
})
