package game

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarsBehaviorTest : BehaviorSpec({
    val testConditions = listOf(
        TestCondition(4, 8, 3),
        TestCondition(3, 4, 4),
        TestCondition(5, 8, 9),
        TestCondition(6, 4, 10),
    )

    testConditions.forEach { (carCount, retryCount, moveConditionCount) ->
        Given("자동차 수 ${carCount}와 시도할 횟수 $retryCount 입력받고") {
            When("고정 이동조건 ${moveConditionCount}이면") {
                val cars = Cars.fromCarCount(carCount, FixedMoveConditionGenerator(moveConditionCount))
                cars.advance(retryCount)
                val positions = cars.carList.map(Car::position)
                val expect = expectedPosition(moveConditionCount, retryCount)
                Then("자동차는 ${carCount}개 생성되고 모든 자동차는 ${expect}만큼 이동한다") {
                    positions.forEach { position ->
                        position shouldBe expect
                    }
                }
            }
        }
    }
}) {
    data class TestCondition(val carCount: Int, val retryCount: Int, val moveConditionCount: Int)
}

fun expectedPosition(moveConditionCount: Int, retryCount: Int): Int {
    return if (moveConditionCount in 4..9) retryCount else 0
}
