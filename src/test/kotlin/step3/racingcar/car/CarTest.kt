package step3.racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `차 이동&멈춤의 상태를 저장한다`() {
        // given
        val moveTestCar = Car()

        // when
        moveTestCar.move()
        val recored1 = moveTestCar.getDrivingRecord()

        // then
        assertThat(recored1.size).isEqualTo(1)
        assertThat(recored1[0]).isEqualTo(Position.MOVE)

        // given
        val stopTestCar = Car()

        // when
        stopTestCar.stop()
        val recored2 = stopTestCar.getDrivingRecord()

        // then
        assertThat(recored2.size).isEqualTo(1)
        assertThat(recored2[0]).isEqualTo(Position.STOP)
    }
}
