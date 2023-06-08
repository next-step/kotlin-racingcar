package racingcar.car

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {
    @ParameterizedTest
    @CsvSource(value = ["0,0", "1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"])
    fun `차 움직임 테스트`(givenRpm: Int, expectedDistance: Int) {
        // given
        val engine = MockEngine(givenRpm)
        val car = Car(engine)

        // when
        car.move()

        // then
        Assertions.assertThat(car.distance).isEqualTo(expectedDistance)
    }
}
