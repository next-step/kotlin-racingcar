package carRacing

import carRacing.model.Car
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

        "car 이름이 5자리 이상인 경우 IllegalArgumentException" {
            val carName = "12345"
            val exception = shouldThrow<IllegalArgumentException> {
                Car(carName)
            }
            exception.message shouldBe Car.INVALID_CAR_LENGTH
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

    "isDrawWith" - {

        "포지션이 동일한 경우 true를 리턴한다." {
            val car1 = Car("car1")
            val car2 = Car("car2")

            val result = car1.isDrawWith(car2)

            result shouldBe true
        }
    }
})
