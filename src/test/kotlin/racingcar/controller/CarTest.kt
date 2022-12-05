package racingcar.controller

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class CarTest : StringSpec({

    "after moving Car, can get current position" {
        val car = Car()
        car.move(1)
        car.move(3)
        car.move(4)

        car.currentPosition shouldBe 8
    }
    "move car" {
        val car = Car(currentPosition = 0)
        car.move()

        car.currentPosition shouldBe 1
    }
    "create Car with name, position" {
        validNames.forEach {
            val car = Car(it, 1)

            car.name shouldBe it
            car.currentPosition shouldBe 1
        }
    }

    "cannot create Car with negative position" {
        shouldThrow<IllegalArgumentException> { Car("mimi", -1) }
    }

    "Car name should not be longer than 5" {
        invalidNames.forEach {
            shouldThrow<IllegalArgumentException> { Car(it) }
        }
    }
}) {
    companion object {
        val validNames = listOf("", "n", "na", "name", "name0")
        val invalidNames = listOf("name01 ", " name012 ", " name013 ")
    }
}
