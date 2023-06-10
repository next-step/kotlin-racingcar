package racing.domain.strategy

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racing.domain.DirectionType
import racing.domain.DirectionType.BACK
import racing.domain.DirectionType.LEFT
import racing.domain.DirectionType.RIGHT
import racing.domain.DirectionType.STOP
import racing.domain.Distance

class StopOrStraightMoveStrategyTest : BehaviorSpec({
    Given("전진 혹은 멈춤 전략은") {
        When("이동 속도가 1이고") {
            val strategy = StopOrStraightMoveStrategy(Distance(1L))

            And("이동 타입이 STRAIGHT 인 경우") {
                val actual = strategy.move(navigator = { DirectionType.STRAIGHT }, baseDistance = Distance.ZERO)

                Then("이동 거리는 1만큼 증가한다") {
                    actual shouldBe Distance(1L)
                }
            }

            listOf(STOP, BACK, LEFT, RIGHT).forEach {
                And("이동 타입이 $it 인 경우") {
                    val actual = strategy.move(navigator = { it }, baseDistance = Distance.ZERO)

                    Then("멈춰 있는다.") {
                        actual shouldBe Distance.ZERO
                    }
                }
            }
        }
    }
})
