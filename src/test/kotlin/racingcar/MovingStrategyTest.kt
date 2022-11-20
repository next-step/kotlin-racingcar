package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class MovingStrategyTest : BehaviorSpec({

    given("이동 전략이") {
        val currentLocation = 0

        `when`("ADVANCE면") {
            val advanceStrategy = MovingStrategy.ADVANCE
            val afterLocation = advanceStrategy.move(currentLocation)

            then("앞으로 1 전진한다.") {
                afterLocation shouldBe 1
            }
        }

        `when`("STOP이면") {
            val stopStrategy = MovingStrategy.STOP
            val afterLocation = stopStrategy.move(currentLocation)

            then("이동하지 않는다.") {
                afterLocation shouldBe 0
            }
        }
    }
})
