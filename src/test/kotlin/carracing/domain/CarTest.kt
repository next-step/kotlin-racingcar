package carracing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "move should increase position when value is greater than default threshold" {
        val threshold = Threshold { it >= 4 }
        val car = Car("test", threshold)
        car.move(5)
        car.position shouldBe 1
    }
})
