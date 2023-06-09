package study.racingcar.car

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({

    val alwaysMoveGenerator = object : MoveGenerator {
        override fun canMove(): Boolean = true
    }
    val neverMoveGenerator = object : MoveGenerator {
        override fun canMove(): Boolean = false
    }

    Given("Car 클래스가 항상 움직이지 않는 조건일 때") {
        When("움직이면") {
            val car = Car("test", neverMoveGenerator)
            car.move()

            Then("위치는 0이어야 한다") {
                car.getCurrentState().position shouldBe 0
            }
        }
    }

    Given("Car 클래스가 항상 움직이는 조건일 때") {
        When("움직이면") {
            val car = Car("test", alwaysMoveGenerator)
            car.move()

            Then("위치는 1이어야 한다") {
                car.getCurrentState().position shouldBe 1
            }
        }
    }

    Given("Car 클래스에 5자를 초과하는 이름을 부여할 때") {
        When("객체를 생성하면") {
            val shouldThrowException = shouldThrow<IllegalArgumentException> {
                Car("5자를 초과하는 이름", alwaysMoveGenerator)
            }

            Then("예외가 발생해야 한다") {
                shouldThrowException.message shouldBe "자동차 이름은 5자를 초과할 수 없습니다."
            }
        }
    }
})
