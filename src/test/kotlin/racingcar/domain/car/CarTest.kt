package racingcar.domain.car

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe
import racingcar.domain.car.carengine.CarEngine

internal class CarTest : BehaviorSpec({

    Given("Car") {
        When("자동차 이름이 5자 이하일 때") {
            val carNames = listOf("t", "te", "tes", "test", "tests")

            Then("생성 완료") {
                carNames.forAll { carName ->
                    Car(carName)
                }
            }
        }

        When("자동차 이름이 5자 초과일 때") {
            val carNames = listOf("testte", "testtes", "testtest")

            Then("IllegalArgumentException 발생") {
                carNames.forAll { carName ->
                    val error = shouldThrow<IllegalArgumentException> { Car(carName) }
                    error.message shouldBe Car.NAME_LIMIT_ERROR_MESSAGE
                }
            }
        }

        When("move() 성공 시") {
            val carEngine = object : CarEngine { override fun canGo(): Boolean = true }
            val car = Car("test", carEngine)
            val previousPosition = car.position
            car.move()

            Then("position 1 증가") {
                car.position shouldBe previousPosition + 1
            }
        }

        When("move() 실패 시") {
            val carEngine = object : CarEngine { override fun canGo(): Boolean = false }
            val car = Car("test", carEngine)
            val previousPosition = car.position
            car.move()

            Then("position 1 증가") {
                car.position shouldBe previousPosition
            }
        }

        When("move() = true, tryCount = 5 일 때 race()") {
            val carEngine = object : CarEngine { override fun canGo(): Boolean = true }
            val car = Car("test", carEngine)
            car.race(5)

            Then("CarRecord.records == {1, 2, 3, 4, 5}") {
                car.carRecord.record shouldContainInOrder listOf(1, 2, 3, 4, 5)
            }
        }
    }
})
