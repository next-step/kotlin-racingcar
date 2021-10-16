package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {
    lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car()
    }

    @DisplayName("자동차의 최초 포지션은 0 이다.")
    @Test
    fun `최초 포지션`() {
        assertThat(car.position)
            .isEqualTo(0);
    }

    @DisplayName("숫자가 4 이상인 경우, 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `전진 가능`(number: Int) {
        car.move(number)
        assertThat(car.position)
            .isEqualTo(1);
    }

    @DisplayName("숫자가 4 미만인 경우, 전진하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `전진 불가능`(number: Int) {
        car.move(number)
        assertThat(car.position)
            .isEqualTo(0);
    }
}
