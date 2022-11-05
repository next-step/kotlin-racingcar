package step3.domain.car

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

internal class CarTest : StringSpec({
    "자동차는 위치값을 갖는다" {
        val car = Car()
        val initPosition = car.currentPosition()
        initPosition.shouldNotBeNull()
    }

    "자동차는 움직이면 위치값이 변한다" {
        val car = Car()
        val initPosition = car.currentPosition()
        val postPosition = car.move()
        initPosition shouldNotBe postPosition
    }

    "자동차는 위치값이 같다고 해서 같은 객체가 아니다" {
        val firstCar = Car()
        val secondCar = Car()
        firstCar.move()
        secondCar.move()
        firstCar.currentPosition() shouldBe secondCar.currentPosition()
        firstCar shouldNotBe secondCar
    }

    "자동차가 멈추면 마지막 위치값을 기억한다" {
        val car = Car()
        car.move()
        car.stop()
        val lastPosition = car.lastPosition
        lastPosition shouldBe car.currentPosition()
    }

    "자동차가 멈추면 이동을 하지 못한다" {
        val car = Car()
        car.move()
        car.stop()
        shouldThrow<IllegalStateException> {
            car.move()
        }
    }
})
