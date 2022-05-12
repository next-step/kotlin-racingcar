package racing

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.CarRacingGame.Companion.START_POSITION
import racing.domain.Car

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 3, 100])
    fun `올바른 자동차 생성자 테스트`(position: Int) {
        Car(position) { false }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -3, -100])
    fun `자동차 생성자 에러 테스트`(position: Int) {
        assertThatIllegalArgumentException().isThrownBy {
            Car(position) { false }
        }.withMessage("자동차의 초기 위치는 0이상 입니다.")
    }

    @Test
    fun `자동차 전진 테스트`() {
        val car = Car(START_POSITION) { true }
        assertThat(car.move()).isEqualTo(1)
    }

    @Test
    fun `자동차 정지 테스트`() {
        val car = Car(START_POSITION) { false }
        assertThat(car.move()).isEqualTo(0)
    }

    @Test
    fun `자동차 위치 저장 테스트`() {
        val car = Car(START_POSITION) { true }
        val history = mutableListOf<Int>()
        repeat(10) {
            car.savePosition(history)
        }
        assertThat(history.size).isEqualTo(10)
    }
}
