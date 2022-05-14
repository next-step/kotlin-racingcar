package carRacing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CarTest : FreeSpec({

    "init" - {

        "car 이름이 빈 문자열 일 경우 IllegalArgumentException" {
            val carName = ""
            val exception = shouldThrow<IllegalArgumentException> {
                Car(carName)
            }
            exception.message shouldBe Car.INVALID_CAR_NAME
        }
    }

    "move" - {

        "car의 포지션이 + 1 되어야한다." {
            val car = Car("test")
            val before = car.position
            car.move()
            car.position shouldBe before + 1
        }
    }
})
