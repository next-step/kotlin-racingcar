package racingcar.domain.car

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import racingcar.exception.InvalidCarNameLengthInput

class CarSpec : StringSpec({
    "자동차 이름은 5자를 초과할 수 없다" {
        val invalidCarName = "invalid_car_name"

        shouldThrow<InvalidCarNameLengthInput> {
            Car(invalidCarName)
        }
    }
})
