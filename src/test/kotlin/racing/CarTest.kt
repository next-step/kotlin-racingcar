package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.domain.Car
import racing.domain.vo.CarMoveResult
import racing.domain.vo.Name
import racing.domain.vo.Position

class CarTest {

    @Test
    fun `자동차는 이동 조건을 만족하면 전진한다`() {
        val car = Car(Name("Test"), Position())
        assertThat(car.move { true }).isEqualTo(CarMoveResult(Name("Test"), Position(1)))
    }

    @Test
    fun `자동차는 이동 조건을 만족하지 않으면 멈춰있다`() {
        val car = Car(Name("Test"), Position())
        assertThat(car.move { false }).isEqualTo(CarMoveResult(Name("Test"), Position(0)))
    }
}
