package car.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `랜덤이 4 미만일경우 움직임은 실패이다`(rand: Int) {
        // given
        val car: Car = Car()
        // when
        val success = car.move(rand)
        // then
        assertThat(success)
            .isFalse()
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `랜덤이 4 이상일경우 움직임은 성공이다`(rand: Int) {
        // given
        val car: Car = Car()
        // when
        val success = car.move(rand)
        // then
        assertThat(success)
            .isTrue()
    }
}
