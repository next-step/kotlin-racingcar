package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racing.mock.FakeForwardCondition

class CarTest {

    @Test
    fun `전진조건이 false 인 경우 distance 는 증가하지 않는다`() {
        // given
        val car = Car(name = "car", forwardCondition = FakeForwardCondition(false))

        // when
        val racingPhaseRecord = car.move()

        // then
        assertThat(racingPhaseRecord.distance).isEqualTo(Car.INITIAL_DISTANCE)
    }

    @Test
    fun `전진조건이 true 인 경우 distance 는 증가한다`() {
        // given
        val car = Car(name = "car", forwardCondition = FakeForwardCondition(true))

        // when
        val racingPhaseRecord = car.move()

        // then
        assertThat(racingPhaseRecord.distance).isEqualTo(Car.INITIAL_DISTANCE + 1)
    }

    @Test
    fun `carName 이 5자를 초과하는 경우 예외 발생한다`() {
        // expect
        assertThrows<IllegalArgumentException> {
            Car(name = "123456", forwardCondition = FakeForwardCondition(true))
        }
    }
}
