package carracing.game.domain.data

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest :
    StringSpec({
        "when randomNumber > 3 should increment position" {
            listOf(4, 5).forEach { randomNumber ->
                val car = Car(name = "Car", generateMoveNumber = { randomNumber })
                car.move()
                car.position shouldBe 1
            }
        }

        "when randomNumber < 4 should do nothing" {
            listOf(-1, 3).forEach { randomNumber ->
                val car = Car(name = "Car", generateMoveNumber = { randomNumber })
                car.move()
                car.position shouldBe 0
            }
        }

        "when name is valid should create Car" {
            listOf("Cart1", " Car   ").forEach { name ->
                shouldNotThrowAny { Car(name = name, generateMoveNumber = { 1 }) }
            }
        }

        "when name in invalid should throw exception" {
            listOf("   ", "Long name").forEach { name ->
                shouldThrowExactly<IllegalArgumentException> { Car(name = name, generateMoveNumber = { 1 }) }
            }
        }

        "toString should return formatted name and position" {
            val car = Car(name = "car", generateMoveNumber = { 1 })
            car.toString() shouldBe "Car(name='car', position=0)"
        }
    })
