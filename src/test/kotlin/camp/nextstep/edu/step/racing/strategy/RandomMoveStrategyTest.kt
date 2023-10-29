package camp.nextstep.edu.step.racing.strategy

import io.kotest.core.spec.style.BehaviorSpec
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

@DisplayName("자동차 이동은")
class RandomMoveStrategyTest : BehaviorSpec ({

    Given("랜덤으로 이동하는 전략이 주어지고") {
        val randomMoveStrategy = RandomMoveStrategy()

        When("이동 요청 시") {
            val isMovable = randomMoveStrategy.isMovable()

            Then("4 이상일 경우 true를 반환한다") {
                assertTrue(isMovable)
            }
        }
    }

    // TODO : 4 이하일 경우 false를 반환해야 하는데, 어떻게 테스트를 해야할까?

})
