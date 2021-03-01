package car.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `랜덤이 4 미만일경우 움직임일 수 있는지 확인할 경우 결과는 실패이다`(rand: Int) {
        // given
        val car: Car = Car()
        // when
        val success = car.isMovable(rand)
        // then
        assertThat(success)
            .isFalse()
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `랜덤이 4 이상일경우 움직임일 수 있는지 확인할 경우 결과는 성공이다`(rand: Int) {
        // given
        val car: Car = Car()
        // when
        val success = car.isMovable(rand)
        // then
        assertThat(success)
            .isTrue()
    }
}
