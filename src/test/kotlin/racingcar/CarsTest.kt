package racingcar

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.BehaviorSpec
import racingcar.condition.AlwaysMoveCondition
import racingcar.condition.NotMoveCondition
import racingcar.condition.RandomMoveCondition
import racingcar.strategy.SatisfyAllConditionStrategy
import racingcar.strategy.SatisfyRandomMoveStrategy
import racingcar.strategy.SatisfySingleConditionMoveStrategy

internal class CarsTest : BehaviorSpec({
    Given("하나라도 만족하면 움직이는 차들이여도, ") {
        val numberOfCars = 3
        val moveConditions = listOf(RandomMoveCondition(), NotMoveCondition(), AlwaysMoveCondition())
        val cars = Cars(
            carNumber = numberOfCars,
            moveStrategy = SatisfySingleConditionMoveStrategy(),
        )
        When("어떤 조건이든, ") {
            Then("정상적으로 동작한다.") {
                shouldNotThrowAny {
                    cars.move(moveConditions)
                }
            }
        }
    }

    Given("모든 조건을 만족하면 움직이는 차들이라면, ") {
        val numberOfCars = 3
        val moveConditions = listOf(RandomMoveCondition(), NotMoveCondition(), AlwaysMoveCondition())
        val cars = Cars(
            carNumber = numberOfCars,
            moveStrategy = SatisfyAllConditionStrategy(),
        )
        When("어떤 조건이든, ") {
            Then("정상적으로 동작한다.") {
                shouldNotThrowAny {
                    cars.move(moveConditions)
                }
            }
        }
    }

    Given("랜덤 조건을 만족하면 움직이는 차들이라면, ") {
        val numberOfCars = 3
        val moveConditions = listOf(RandomMoveCondition(), NotMoveCondition(), AlwaysMoveCondition())
        val cars = Cars(
            carNumber = numberOfCars,
            moveStrategy = SatisfyRandomMoveStrategy(),
        )
        When("어떤 조건이든, ") {
            Then("정상적으로 동작한다.") {
                shouldNotThrowAny {
                    cars.move(moveConditions)
                }
            }
        }
    }
})
