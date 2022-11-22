package racing.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CarsTest : FreeSpec({

    "tryMoveCars" - {

        "Car들이 전체 움직인다." {
            val carsName = "pobi,crong,honux".split(",")
            val cars = Cars(
                carsName.map { Car(CarName(it)) },
                object : CarMoveStrategy {
                    override fun isMovable(): Boolean {
                        return true
                    }
                }
            )
            cars.tryMoveCars()

            cars.cars.map { it.position.value } shouldBe listOf(1, 1, 1)
        }
    }

    "winner" - {

        "우승자를 출력한다." - {
            val cars = Cars(
                listOf(Car(CarName("pobi"), Position(value = 1)), Car(CarName("crong"), Position(value = 1))),
                RandomStrategy()
            )
            val winnerNames = cars.winner().map { it.carName.name }

            winnerNames shouldBe listOf("pobi", "crong")
        }
    }
})
