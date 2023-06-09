package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.mock.FakeForwardCondition

class CarTest {

    @Test
    fun `전진조건이 false 인 경우 distance 는 증가하지 않는다`() {
        // given
        val car = Car(forwardCondition = FakeForwardCondition(false))

        // when
        car.move()

        // then
        assertThat(car.distance).isEqualTo(Car.INITIAL_DISTANCE)
    }

    @Test
    fun `전진조건이 true 인 경우 distance 는 증가한다`() {
        // given
        val car = Car(forwardCondition = FakeForwardCondition(true))

        // when
        car.move()

        // then
        assertThat(car.distance).isEqualTo(Car.INITIAL_DISTANCE + 1)
    }
}
