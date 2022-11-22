package racing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({

    "자동차 생성" {
        val car = Car()

        car shouldBe Car()
    }

    "자동차의 초기 위치는 0이다" {
        val car = Car()

        car.samePosition(0) shouldBe true
    }
})
