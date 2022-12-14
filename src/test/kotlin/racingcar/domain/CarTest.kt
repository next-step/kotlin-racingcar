package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class CarTest : StringSpec({

    "create Car with name, position" {
        listOf("", "n", "na", "name", "name0")
            .forEach {
                val car = Car(it, 1)

                car.name shouldBe it
                car.currentPosition shouldBe 1
            }
    }

    "cannot create Car with negative position" {
        shouldThrow<IllegalArgumentException> { Car("mimi", -1) }
    }

    "Car name should not be longer than 5" {
        listOf("name01 ", " name012 ", " name013 ")
            .forEach {
                shouldThrow<IllegalArgumentException> { Car(it) }
            }
    }
    "Car moves If condition is equal or greater than 4" {
        listOf(4, 5, 6, 7, 8, 9, 100)
            .forEach {
                val car = Car("test")
                car.move(it)
                car.currentPosition shouldBe 1
            }
    }

    "Car doesn't move If condition is smaller than 4" {
        listOf(-100, 0, 1, 2, 3)
            .forEach {
                val car = Car("test")
                car.move(it)
                car.currentPosition shouldBe 0
            }
    }
})
