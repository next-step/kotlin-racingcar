package racing.domain.strategy

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.util.concurrent.ThreadLocalRandom

class ThresholdBasedMoveStrategyTest : BehaviorSpec({
    given("ThresholdBasedMoveStrategy 전략은") {
        `when`("값이 4 초과인 경우") {
            val actual = ThresholdBasedMoveStrategy { ThreadLocalRandom.current().nextInt(4, 10) }.run { movable() }

            then("true를 반환한다") {
                actual shouldBe true
            }
        }

        `when`("값이 4 이하인 경우") {
            val actual = ThresholdBasedMoveStrategy { ThreadLocalRandom.current().nextInt(0, 4) }.run { movable() }

            then("false를 반환한다") {
                actual shouldBe false
            }
        }
    }
})
