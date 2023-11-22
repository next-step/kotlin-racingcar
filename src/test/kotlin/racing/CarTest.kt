package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
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

    @ValueSource(strings = ["car1", "car2"])
    @ParameterizedTest
    fun `자동차는 이름을 가질 수 있다`(name: String) {
        val car = Car(name)
        Assertions.assertThat(car.getName()).isEqualTo(name)
    }

    @ValueSource(strings = ["camila", "hyundai"])
    @ParameterizedTest
    fun `자동차는 이름을 5자를 초과할 수 없다`(name: String) {
        Assertions.assertThatThrownBy {
            val car = Car(name)
        }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름은 5자 이상될 수 없습니다.")
    }

    @Test
    fun `0~9사이의 랜덤값을 뽑아 4이상인 경우에 움직인다`() {
        val car = Car(CarName("test"))
        val movingRule = TestMovingRuleTrue(1)
        car.forward(movingRule)
        Assertions.assertThat(car.route).isEqualTo(1)
    }

    @Test
    fun `0~9사이의 랜덤값을 뽑아 4미만이면 경우에 움직이지 않는다`() {
        val car = Car(CarName("test"))
        val movingRule = TestMovingRuleFalse(1)
        car.forward(movingRule)
        Assertions.assertThat(car.route).isEqualTo(0)
    }
}
