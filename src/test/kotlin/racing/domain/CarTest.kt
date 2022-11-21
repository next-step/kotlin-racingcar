package racing.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CarTest : FreeSpec({

    "move" - {

        "Car의 position이 한칸 움직인다." {
            val car = Car(CarName("pobi"))
            car.move()

            car.position.value shouldBe 1
        }
    }
})
