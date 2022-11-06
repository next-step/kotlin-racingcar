package racingcar

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.BehaviorSpec
import racingcar.condition.RandomMoveCondition

internal class CarsTest : BehaviorSpec({
    Given("차의 개수가 주어지면") {
        val numberOfCars = 3
        val cars = Cars(numberOfCars, listOf(RandomMoveCondition()))
        When("움직일 수 있는 조건이 true일 때 움직이려고 하면,") {
            Then("문제없이 앞으로 전진한다.") {
                shouldNotThrowAny {
                    cars.move()
                }
            }
        }
    }
})
