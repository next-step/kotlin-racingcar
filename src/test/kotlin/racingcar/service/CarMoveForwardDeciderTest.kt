package racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarMoveForwardDeciderTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `자동차 전진불가 테스트`(value: Int) {
        val canMoveForward = CarMoveForwardDecider(CarMoveForwardFixedValueGetter(value)).canMoveForward()

        assertThat(canMoveForward).isFalse
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `자동차 전진가능 테스트`(value: Int) {
        val canMoveForward = CarMoveForwardDecider(CarMoveForwardFixedValueGetter(value)).canMoveForward()

        assertThat(canMoveForward).isTrue
    }
}
