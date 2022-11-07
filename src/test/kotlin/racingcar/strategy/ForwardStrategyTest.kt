package racingcar.strategy

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.util.random.RandomNumber

class ForwardStrategyTest : BehaviorSpec({
    given("move 메서드를 호출할 때") {
        `when`("랜덤 값이 4보다 작다면") {
            val forwardStrategy = ForwardStrategy(RandomNumber(lessThan4Range))
            then("false 를 반환한다.") {
                forwardStrategy.move() shouldBe false
            }
        }

        `when`("랜덤 값이 4보다 같거나 크다면") {
            val forwardStrategy = ForwardStrategy(RandomNumber(greaterThanOrEquals4Range))
            then("true 를 반환한다.") {
                forwardStrategy.move() shouldBe true
            }
        }
    }
}) {
    companion object {
        private val lessThan4Range = (0..3)
        private val greaterThanOrEquals4Range = (4..9)
    }
}
