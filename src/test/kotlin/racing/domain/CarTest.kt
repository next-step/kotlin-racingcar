package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.Car
import racing.goEngine
import racing.stopEngine

@Suppress("NonAsciiCharacters")
class CarTest {

    private val name = CarName("name")
    private val otherName = CarName("other")

    @Test
    fun `처음 생성된 차의 위치는 0이다`() {
        assertThat(Car(goEngine, name).position).isEqualTo(Position(0))
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `차가 n번 움직이면 위치가 n만큼 증가한다`(count: Int) {
        val car = Car(goEngine, name)

        repeat(count) {
            car.go()
        }

        assertThat(car.position).isEqualTo(Position(count))
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `차가 움직이지 못하면 위치가 변하지 않는다`(count: Int) {
        val car = Car(stopEngine, name)

        repeat(count) {
            car.go()
        }

        assertThat(car.position).isEqualTo(INITIAL_POSITION)
    }

    @Test
    fun `포지션 값이 다른 차보다 크면 앞서있다`() {
        val ahead = Car(name, 3)
        val behind = Car(otherName, 2)

        assertAll(
            { assertThat(ahead.isAheadOf(behind)).isTrue },
            { assertThat(behind.isAheadOf(ahead)).isFalse },
        )
    }

    @Test
    fun `포지션 값이 다른 차와 같으면 비긴다`() {
        val car = Car(name, 2)
        val other = Car(otherName, 2)

        assertAll(
            { assertThat(car.isDrawWith(other)).isTrue },
            { assertThat(other.isDrawWith(car)).isTrue },
        )
    }
}
