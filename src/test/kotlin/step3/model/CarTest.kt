package step3.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import step3.util.NumberGenerator

class CarTest : FunSpec({

    test("move fail") {
        val car = Car(object: NumberGenerator {
            override fun generate(minValue: Int, maxValue: Int): Int {
                return Car.MOVABLE_THRESHOLD - 1
            }
        })
        car.move() shouldBe false
    }

    test("move success") {
        val car = Car(object: NumberGenerator {
            override fun generate(minValue: Int, maxValue: Int): Int {
                return Car.MOVABLE_THRESHOLD
            }
        })
        car.move() shouldBe true
    }
})
