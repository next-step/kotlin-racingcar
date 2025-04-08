package carracing.game.domain.data

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest :
    StringSpec({
        "when randomNumber > 3 should increment position" {
            listOf(4, 5).forEach { randomNumber ->
                Car.of(name = "Car", generateMoveNumber = { randomNumber }).apply { move() }.position shouldBe 1
            }
        }

        "when randomNumber < 4 should do nothing" {
            listOf(-1, 3).forEach { randomNumber ->
                Car.of(name = "Car", generateMoveNumber = { randomNumber }).apply { move() }.position shouldBe 0
            }
        }

        "when name is valid should create Car" {
            listOf("Cart1", " Car   ").forEach { name ->
                shouldNotThrowAny { Car.of(name = name, generateMoveNumber = { 1 }) }
            }
        }

        "when name in invalid should throw exception" {
            listOf(null, "   ", "Long name").forEach { name ->
                shouldThrowExactly<IllegalArgumentException> { Car.of(name = name, generateMoveNumber = { 1 }) }
            }
        }

        "toString should return formatted name and position" {
            val car = Car.of(name = "car", generateMoveNumber = { 1 })
            car.toString() shouldBe "car : "
            val car1 = Car.of(position = 2, name = "car1", generateMoveNumber = { 1 })
            car1.toString() shouldBe "car1 : --"
        }
    })
