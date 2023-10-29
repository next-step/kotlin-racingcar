package racingcar.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({

    "자동차 객체 생성시 위치가 0인 객체가 생성 된다" {
        val car = Car()

        car.position shouldBe 0
    }

    "자동차 객체의 move 메서드로 postion이 1 증가 한다" {
        val car = Car()
        car.move()

        car.position shouldBe 1
    }

    "자동차 객체를 3번 움직이게 하면 위치가 3이된다" {
        val car = Car()
        repeat(3) {
            car.move()
        }
        car.position shouldBe 3
    }
})
