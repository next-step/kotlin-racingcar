package racing.domain.strategy

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racing.domain.DirectionType
import java.util.concurrent.ThreadLocalRandom

class ThresholdBasedMoveStrategyTest : BehaviorSpec({
    Given("ThresholdBasedMoveStrategy 전략은") {
        When("값이 4 초과인 경우") {
            val actual = ThresholdBasedMovableStrategy { ThreadLocalRandom.current().nextInt(4, 10) }.run { navigate() }

            Then("STRAIGHT 를 반환한다") {
                actual shouldBe DirectionType.STRAIGHT
            }
        }

        When("값이 4 이하인 경우") {
            val actual = ThresholdBasedMovableStrategy { ThreadLocalRandom.current().nextInt(0, 4) }.run { navigate() }

            Then("STOP 를 반환한다") {
                actual shouldBe DirectionType.STOP
            }
        }
    }
})
