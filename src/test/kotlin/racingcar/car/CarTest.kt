package racingcar.car

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CarTest : ShouldSpec({
    context("Create") {
        should("create a car") {
            shouldNotThrowAny {
                Car("sun")
            }
        }

        should("position of the car be 0") {
            Car("sun").position shouldBe 0
        }
    }

    context("Move") {
        should("move a car") {
            val car = Car("sun", canMove = { true })
            car.move()

            car.position shouldBe 1
        }

        should("not move a car") {
            listOf(0, 1, 2, 3).forAll {
                val car = Car("sun", canMove = { false })
                car.move()

                car.position shouldBe 0
            }
        }
    }
})
