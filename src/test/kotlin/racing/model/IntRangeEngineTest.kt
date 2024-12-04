package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class IntRangeEngineTest {
    @ParameterizedTest
    @CsvSource("0, 1", "0, 3", "2, 3")
    fun `랜덤 값이 4미만인 경우, 자동차는 정지합니다`(
        rangeMin: Int,
        rangeMax: Int,
    ) {
        val forwardLimit = 4
        val engine = IntRangeEngineFactory.create(
            forwardLimit = forwardLimit,
            range = rangeMin..rangeMax,
        )
        assertThat(engine.canMoveForward())
            .isFalse()
    }

    @ParameterizedTest
    @CsvSource("4, 5", "5, 8", "4, 9")
    fun `랜덤 값이 4이상인 경우, 자동차는 전진합니다`(
        rangeMin: Int,
        rangeMax: Int,
    ) {
        val forwardLimit = 4
        val engine = IntRangeEngineFactory.create(
            forwardLimit = forwardLimit,
            range = rangeMin..rangeMax,
        )
        assertThat(engine.canMoveForward())
            .isTrue()
    }
}
