package step3.racingcar.car

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

    @Test
    fun `차 멈춤을 호출하면 위치값은 동일하다 변하지 않는다`() {
        // given
        val testCar = Car()
        val comparingCar = Car()

        // when
        testCar.stop()

        // then
        assertThat(testCar.currentDrivingRecord).isEqualTo(comparingCar.currentDrivingRecord)
    }
}
