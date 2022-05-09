package car_racing

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CarTest : FreeSpec({

    "move" - {

        "car의 포지션이 + 1 되어야한다." {
            val car = Car()
            car.move()
            car.position shouldBe 1
        }
    }
})
