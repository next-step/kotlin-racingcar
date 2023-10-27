package game

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarsBehaviorTest : BehaviorSpec({
    Given("자동차 경주 게임을 시작하면") {
        When("자동차 수와 시도할 횟수를 입력받으면") {
            val carCount = 3
            val retryCount = 5
            val cars = Cars.fromCarCount(carCount, FixedMoveConditionGenerator(4))
            // when
            cars.advance(retryCount)
            val positions = cars.carList.map(Car::position)
            then("자동차 수만큼 자동차가 생성되고 시도할 횟수만큼 자동차가 이동한다") {
                // then
                positions.forEach { position ->
                    position shouldBe retryCount
                }
            }
        }
    }
})
