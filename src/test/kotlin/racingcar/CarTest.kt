package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import racingcar.domain.Car
import racingcar.domain.condition.NotMoveCondition
import racingcar.domain.condition.RandomMoveCondition
import racingcar.domain.condition.TestCondition
import racingcar.domain.strategy.SatisfyAllConditionStrategy
import racingcar.domain.strategy.SatisfyRandomMoveStrategy
import racingcar.domain.strategy.SatisfySingleConditionMoveStrategy

internal class CarTest : BehaviorSpec({
    val randomMoveCondition = mockk<RandomMoveCondition>()
    val notMoveCondition = NotMoveCondition()
    Given("모든 조건을 만족해야 움직이는 차가 존재한다면,") {
        val name = "테스트 차"
        val position = 0
        When("움직이지 못하는 조건이 포함되어있다면, 랜덤 값이 true 이더라도") {
            every { randomMoveCondition.isAvailable() } returns true
            val moveConditions = listOf(randomMoveCondition, notMoveCondition)
            val car = Car(name, SatisfyAllConditionStrategy(moveConditions), position)
            val result = car.move()
            Then("앞으로 전진할 수 없다.") {
                result shouldBe position
            }
        }

        When("움직이지 못하는 조건이 포함되어있다면, 랜덤 값이 false 라면") {
            every { randomMoveCondition.isAvailable() } returns false
            val moveConditions = listOf(randomMoveCondition, notMoveCondition)
            val car = Car(name, SatisfyAllConditionStrategy(moveConditions), position)
            val result = car.move()
            Then("당연히 앞으로 전진할 수 없다.") {
                result shouldBe position
            }
        }
    }

    Given("하나의 조건만 만족하면 움직이는 차가 존재한다면,") {
        val name = "테스트 차"
        val position = 0
        When("움직이지 못하는 조건이 포함되어있다면, 랜덤 값이 true 라면") {
            every { randomMoveCondition.isAvailable() } returns true
            val moveConditions = listOf(randomMoveCondition, notMoveCondition)
            val car = Car(name, SatisfySingleConditionMoveStrategy(moveConditions), position)
            val result = car.move()
            Then("앞으로 전진할 수 있다.") {
                result shouldBe position + Car.SPEED
            }
        }

        When("움직이지 못하는 조건이 포함되어있다면, 랜덤 값이 false 라면") {
            every { randomMoveCondition.isAvailable() } returns false
            val moveConditions = listOf(randomMoveCondition, notMoveCondition)
            val car = Car(name, SatisfySingleConditionMoveStrategy(moveConditions), position)
            val result = car.move()
            Then("앞으로 전진할 수 없다.") {
                result shouldBe position
            }
        }
    }

    Given("랜덤 조건만 만족하면 움직이는 차가 존재한다면,") {
        val name = "테스트 차"
        val position = 0
        When("다른 조건이 true 라도 랜덤 조건이 false 라면") {
            every { randomMoveCondition.isAvailable() } returns false
            val car = Car(name, SatisfyRandomMoveStrategy(randomMoveCondition), position)
            val result = car.move()
            Then("앞으로 전진할 수 없다.") {
                result shouldBe position
            }
        }

        When("다른 조건이 false 지만 랜덤 조건이 true 라면,") {
            every { randomMoveCondition.isAvailable() } returns true
            val car = Car(name, SatisfyRandomMoveStrategy(randomMoveCondition), position)
            val result = car.move()
            Then("앞으로 전진할 수 있다.") {
                result shouldBe position + Car.SPEED
            }
        }
    }

    Given("차가 존재한다면,") {
        val name = "테스트 차"
        val position = 0
        When("움직이지 조건이 포함되어있다면, ") {
            val moveConditions = listOf(TestCondition())
            val car = Car(name, SatisfySingleConditionMoveStrategy(moveConditions), position)
            val result = car.move()
            Then("앞으로 전진할 수 있다.") {
                result shouldBe position + Car.SPEED
            }
        }
    }
})
