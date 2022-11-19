package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange

class CarSpec : StringSpec({
    "0과 1사이의 수를 랜덤하게 반환한다" {
        // arrange
        val car = Car()

        // act
        val result = car.move()

        // assert
        result shouldBeInRange 0..1
    }
})
