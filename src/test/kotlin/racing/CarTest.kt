package racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "자동차가 움직이면 위치가 1 증가한다" {
        val car = Car(0)

        car.move(movePolicy = { true })

        car.position shouldBe 1
    }

    "자동차가 정지하면 위치가 증가하지 않는다." {
        val car = Car(0)

        car.move(movePolicy = { false })

        car.position shouldBe 0
    }
})
