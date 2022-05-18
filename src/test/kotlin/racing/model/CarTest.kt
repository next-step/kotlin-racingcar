package racing.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith

class CarTest : FunSpec({

    val neverMovingCar = Car("car") { _, _ -> Car.MOVABLE_THRESHOLD - 1 }
    val alwaysMovingCar = Car("car") { _, _ -> Car.MOVABLE_THRESHOLD }

    test("Invalid Name Length") {
        val exceptionForValue = shouldThrow<IllegalArgumentException> {
            Car("")
            Car("  ")
            Car("abcdef")
        }
        exceptionForValue.message shouldStartWith("Invalid Name Length")
    }

    test("move fail") {
        neverMovingCar.move() shouldBe false
    }

    test("move success") {
        alwaysMovingCar.move() shouldBe true
    }
})
