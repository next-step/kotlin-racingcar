package racingcar.domain.car

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import racingcar.exception.InvalidCarNameLengthInput

class CarSpec : StringSpec({
    "자동차 이름은 5자를 초과할 수 없다" {
        val invalidCarName = "invalid_car_name"

        shouldThrow<InvalidCarNameLengthInput> {
            Car(invalidCarName)
        }
    }

    "주어진 수가 4 이상일 때만 움직인다" {
        val car = Car("pony")
        val result = car.move(4)

        result shouldBe 1
    }

    "주어진 수가 4 미만일 때 움직이지 않는다" {
        val car = Car("pony")
        val result = car.move(3)

        result shouldBe 0
    }

    "0과 9사이의 수를 랜덤하게 반환한다" {
        val car = Car("pony")
        val result = car.getRandomNumber()

        result shouldBeInRange 0..9
    }
})
