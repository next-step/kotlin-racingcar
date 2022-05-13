package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `차를 이동 후 현재 위치결과를 반환한다`() {
        // given
        val testCar = Car()

        // when
        testCar.move()

        // then
        assertThat(testCar.currentDrivingRecord).isEqualTo(1)
    }
}
