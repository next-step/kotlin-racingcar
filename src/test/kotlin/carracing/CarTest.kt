package carracing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "move 는 현재 거리에서 이동거리를 더한다" {
        // given
        val nowDistance = 10
        val moveDistance = 20
        val car = Car(nowDistance)

        // when
        car.move(moveDistance)

        // then
        car.distance shouldBe nowDistance + moveDistance
    }
})
