package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `자동차를 움직이면 위치가 인자만큼 증가한다`(distance: Int) {
        val car = Car()
        car.move(distance)
        assertThat(car.position).isEqualTo(distance)
    }
}