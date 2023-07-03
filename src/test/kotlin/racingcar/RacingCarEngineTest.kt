package racingcar

import domain.RacingCarEngine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingCarEngineTest {

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `엔진 동작이 성공할 때`(number: Int) {
        assertThat(RacingCarEngine().isMoving(number)).isEqualTo(true)
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `엔진 동작이 실패할 때`(number: Int) {
        assertThat(RacingCarEngine().isMoving(number)).isEqualTo(false)
    }
}
