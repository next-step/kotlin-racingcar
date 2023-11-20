package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racing.domain.Car
import racing.domain.CarName
import racing.domain.MovingRule

class CarTest {
    class TestMovingRuleTrue(override val movingCount: Int) : MovingRule {
        override fun isMove(): Boolean {
            return true
        }
    }

    class TestMovingRuleFalse(override val movingCount: Int) : MovingRule {
        override fun isMove(): Boolean {
            return false
        }
    }

    @Test
    fun `자동차 forward 테스트 isMoving=true`() {
        val car = Car(CarName("test"))
        val movingRule = TestMovingRuleTrue(1)
        car.forward(movingRule)
        Assertions.assertThat(car.route).isEqualTo(1)
    }

    @Test
    fun `자동차 forward 테스트 isMoving=false`() {
        val car = Car(CarName("test"))
        val movingRule = TestMovingRuleFalse(1)
        car.forward(movingRule)
        Assertions.assertThat(car.route).isEqualTo(0)
    }
}
