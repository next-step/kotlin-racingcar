package step3.domain.car

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldNotBe

internal class CarTest : StringSpec({
    "자동차는 위치값을 갖는다" {
        val car = Car()
        val initPosition = car.isCurrentPosition()
        initPosition.shouldNotBeNull()
    }

    "자동차는 움직이면 위치값이 변한다" {
        val car = Car()
        val initPosition = car.isCurrentPosition()
        val postPosition = car.move()
        initPosition shouldNotBe postPosition
    }
})
