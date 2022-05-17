package step3.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith

class CarTest : FunSpec({

    test("Invalid Name Length") {
        val exceptionForValue = shouldThrow<IllegalArgumentException> {
            Car("")
            Car("  ")
            Car("abcdef")
        }
        exceptionForValue.message shouldStartWith("Invalid Name Length")
    }

    test("move fail") {
        val car = Car("car") { _, _ -> Car.MOVABLE_THRESHOLD - 1 }
        car.move() shouldBe false
    }

    test("move success") {
        val car = Car("car") { _, _ -> Car.MOVABLE_THRESHOLD }
        car.move() shouldBe true
    }
})
