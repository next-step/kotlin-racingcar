package carracing.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "자동차 이름, 거리를 가지고 있다" {
        // given
        val carName = "Car"
        val carDistance = 3

        // when
        val car = Car(carName, carDistance)

        // then
        car.distance shouldBe carDistance
        car.name shouldBe carName
    }

    "move 는 현재 거리에서 이동거리를 더한다" {
        // given
        val nowDistance = 10
        val moveDistance = 20
        val car = Car("Car", nowDistance)

        // when
        car.move(moveDistance)

        // then
        car.distance shouldBe nowDistance + moveDistance
    }

    "자동차 이름을 공백만 입력하면 IllegalArgumentException 발생한다" {
        // given
        val carName = " "

        // then
        shouldThrowExactly<IllegalArgumentException> {
            Car.validateForCarName(carName)
        }.message shouldBe "자동차 이름은 공백이 올수 없습니다"
    }

    "자동차 이름을 5자 초과하면 IllegalArgumentException 발생한다" {
        // given
        val carName = "123456"

        // when
        val exception = shouldThrowExactly<IllegalArgumentException> {
            Car.validateForCarName(carName)
        }

        // then
        exception.message shouldBe "자동차 이름은 5글자를 초과할수 없습니다"
    }
})
