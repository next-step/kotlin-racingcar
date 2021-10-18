package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class CarTest {

    @Test
    fun `처음 생성된 차의 위치는 0이다`() {
        assertThat(Car(goEngine).position).isEqualTo(Position(0))
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `차가 n번 움직이면 위치가 n만큼 증가한다`(count: Int) {
        val car = Car(goEngine)

        repeat(count) {
            car.go()
        }

        assertThat(car.position).isEqualTo(Position(count))
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `차가 움직이지 못하면 위치가 변하지 않는다`(count: Int) {
        val car = Car(stopEngine)

        repeat(count) {
            car.go()
        }

        assertThat(car.position).isEqualTo(INITIAL_POSITION)
    }
}
