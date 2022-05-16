package step3.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({

    test("move fail") {
        val car = Car { _, _ -> Car.MOVABLE_THRESHOLD - 1 }
        car.move() shouldBe false
    }

    test("move success") {
        val car = Car { _, _ -> Car.MOVABLE_THRESHOLD }
        car.move() shouldBe true
    }
})
