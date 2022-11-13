package racing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec() {
    init {
        "자동차는 움직일 수 있다" {
            val goStrategy: MoveStrategy = object : MoveStrategy {
                override fun canMove(): Boolean = true
            }
            val car = Car(0, goStrategy)

            val position = car.move()

            position shouldBe Position(1)
        }

        "자동차는 멈춰있을 수도 있다" {
            val stopStrategy: MoveStrategy = object : MoveStrategy {
                override fun canMove(): Boolean = false
            }
            val car = Car(0, stopStrategy)

            val position = car.move()

            position shouldBe Position()
        }
    }
}
