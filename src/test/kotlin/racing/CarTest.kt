package racing

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.CarRacingGame.Companion.START_POSITION
import racing.model.Car
import racing.model.PositionHistory

class CarTest {
    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car(START_POSITION)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 100])
    fun `올바른 자동차 생성자 테스트`(position: Int) {
        Car(position)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -3, -100])
    fun `자동차 생성자 에러 테스트`(position: Int) {
        assertThatIllegalArgumentException().isThrownBy {
            Car(position)
        }.withMessage("자동차의 초기 위치는 0이상 입니다.")
    }

    @Test
    fun `자동차 전진 테스트`() {
        assertThat(car.move { true }).isEqualTo(1)
    }

    @Test
    fun `자동차 정지 테스트`() {
        assertThat(car.move { false }).isEqualTo(0)
    }

    @Test
    fun `자동차 위치 저장 테스트`() {
        // given
        val positionHistory = PositionHistory(mutableListOf())

        // when
        repeat(10) {
            car.savePosition(positionHistory)
        }

        // then
        assertThat(positionHistory.size()).isEqualTo(10)
    }
}
