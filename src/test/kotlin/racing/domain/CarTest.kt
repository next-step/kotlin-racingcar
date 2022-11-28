package racing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class CarTest : StringSpec({

    lateinit var car: Car

    beforeTest {
        car = testCar()
    }

    "자동차 생성" {
        car shouldBe Car.from("test")
    }

    "자동차의 초기 위치는 0이다" {
        car.samePosition(0) shouldBe true
    }

    "자동차가 전진하면 위치 값이 1 증가한다" {
        car.move(true)

        car shouldBe testCar(1)
    }

    "자동차가 전진하지 않으면 위치 값의 변화가 없다" {
        car.move(false)

        car shouldBe testCar(0)
    }

    "이름이 다른 자동차는 다른 자동차이다" {
        Car.from("528i") shouldNotBe Car.from("520d")
    }
})

fun testCar(): Car {
    return Car(Name("test"))
}

fun testCar(position: Int = 0): Car {
    return Car.of("test", position)
}
