package racing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({

    lateinit var car: Car

    beforeTest {
        car = Car()
    }

    "자동차 생성" {
        car shouldBe Car()
    }

    "자동차의 초기 위치는 0이다" {
        car.samePosition(0) shouldBe true
    }

    "자동차가 전진하면 위치 값이 1 증가한다" {
        car.move(true)

        car shouldBe Car(1)
    }

    "자동차가 전진하지 않으면 위치 값의 변화가 없다" {
        car.move(false)

        car shouldBe Car(0)
    }
})
