package racingcar.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions

class CarTest : StringSpec({

    "자동차 객체 생성시 위치가 0인 객체가 생성 된다" {
        val car = Car("jason")

        car.position shouldBe 0
    }

    "자동차 객체의 move 시 규칙에 해당하면 위치가 1 증가한다" {
        val car = Car("pobi", moveCondition = SuccessMovement())
        val before = car.position
        car.move()

        car.position shouldBe before + 1
    }

    "자동차 객체의 move 시 규칙에 부합하지 않으면 위치가 증가하지 않는다" {
        val car = Car("pobi", moveCondition = FailMovement())
        val before = car.position
        car.move()

        car.position shouldBe before
    }

    "자동차 객체의 move 시 규칙에 3번 해당하면 위치가 3이된다" {
        val car = Car("car", moveCondition = SuccessMovement())
        repeat(3) {
            car.move()
        }
        car.position shouldBe 3
    }

    "자동차 이름은 5자를 초과할 수 없다" {
        Assertions.assertThatThrownBy {
            Car("racingcar")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
})
