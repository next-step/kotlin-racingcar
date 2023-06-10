package racingcar.car

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `차 움직이지 않을 경우`(givenRpm: Int) {
        // given
        val engine = MockEngine(givenRpm)
        val car = Car(engine)

        // when
        car.move()

        // then
        Assertions.assertThat(car.distance).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `차가 움직일 때 테스트`(givenRpm: Int) {
        // given
        val engine = MockEngine(givenRpm)
        val car = Car(engine)

        // when
        car.move()

        // then
        Assertions.assertThat(car.distance).isEqualTo(1)
    }
}
