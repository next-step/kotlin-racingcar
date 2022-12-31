package racingcar.domain

import io.kotest.assertions.assertSoftly
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
        listOf(4, 5, 6, 7, 8, 9)
            .forEach {
                val car = Car("test")
                car.move(it)
                car.currentPosition shouldBe 1
            }
    }

    "Car moves by 1 from current position If condition is equal or greater than 4" {
        val car = Car("test", 1)
        car.move(4)
        car.currentPosition shouldBe 2
    }

    "Car doesn't move If condition is smaller than 4" {
        listOf(0, 1, 2, 3)
            .forEach {
                val car = Car("test")
                car.move(it)
                car.currentPosition shouldBe 0
            }
    }
    "Car move fails If condition is not between 0,9" {
        listOf(-1, -100, 10, 11, 100)
            .forEach {
                val car = Car("test")
                shouldThrow<IllegalArgumentException> { car.move(it) }
            }
    }
    "Car is comparable" {
        val car = Car("test", 2)
        assertSoftly {
            car.compareTo(Car("other", 1)) shouldBe -1
            car.compareTo(Car("other", 2)) shouldBe 0
            car.compareTo(Car("other", 3)) shouldBe 1
        }
    }
})
