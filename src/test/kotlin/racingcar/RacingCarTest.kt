package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingCarTest {
    @Test
    fun `Racing car 생성자 파라미터 숫자만큼 Car의 인스턴스를 생성한다`() {
        val carNames = listOf("a", "b", "c")
        val racingCar = RacingCar(carNames)
        assertThat(racingCar.cars.size).isEqualTo(carNames.size)
    }

    @Test
    fun `moveForward`() {
        val position = Car("a").moveForward()
        assertThat(position in 0..1).isTrue()
    }

    @Test
    fun `greaterThanOrEqualToMovableValue`() {
        assertThat(greaterThanOrEqualToMovableValue(4)).isTrue()
        assertThat(greaterThanOrEqualToMovableValue(3)).isTrue()
    }
}
