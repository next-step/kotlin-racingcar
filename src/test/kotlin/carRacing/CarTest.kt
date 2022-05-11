package carRacing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest: StringSpec({
    "forward 는 앞으로 전진한다" {
        // given
        val car = Car()

        // when
        car.forward()

        // then
        car.distance shouldBe 1
    }
})