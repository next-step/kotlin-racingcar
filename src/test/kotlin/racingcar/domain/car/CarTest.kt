package racingcar.domain.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe

internal class CarTest : BehaviorSpec({

    Given("Car") {
        When("move() 성공 시") {
            val carEngine = object : CarEngine { override fun canGo(): Boolean = true }
            val car = Car(carEngine)
            val previousPosition = car.position
            car.move()

            Then("position 1 증가") {
                car.position shouldBe previousPosition + 1
            }
        }

        When("move() 실패 시") {
            val carEngine = object : CarEngine { override fun canGo(): Boolean = false }
            val car = Car(carEngine)
            val previousPosition = car.position
            car.move()

            Then("position 1 증가") {
                car.position shouldBe previousPosition
            }
        }

        When("move() = true, tryCount = 5 일 때 race()") {
            val carEngine = object : CarEngine { override fun canGo(): Boolean = true }
            val car = Car(carEngine)
            car.race(5)

            Then("CarRecord.records == {1, 2, 3, 4, 5}") {
                car.carRecord.record shouldContainInOrder listOf(1, 2, 3, 4, 5)
            }
        }
    }
})
