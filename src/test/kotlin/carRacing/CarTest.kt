package carRacing

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CarTest : FreeSpec({

    "move" - {

        "car의 포지션이 + 1 되어야한다." {
            val car = Car()
            val before = car.position
            car.move()
            car.position shouldBe before + 1
        }
    }
})
