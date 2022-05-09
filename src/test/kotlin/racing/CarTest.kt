package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 9, 10, 15])
    fun `임계점 이상의 값이 오면 전진, 아니면 정지한다`(power: Int) {
        val moveThreshold = 10
        val car = Car(moveThreshold)
        car.move(power)

        val expect = if (power >= moveThreshold) 1 else 0
        assertThat(car.position).isEqualTo(expect)
    }
}
