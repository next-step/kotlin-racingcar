package step3.domain.car

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull

internal class CarTest : StringSpec({
    "자동차는 위치값을 갖는다" {
        val car = Car()
        val initPosition = car.isCurrentPosition()
        initPosition.shouldNotBeNull()
    }
})
