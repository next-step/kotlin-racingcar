package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class ScoreTest {

    @ParameterizedTest
    @CsvSource(value = ["1:2:false", "5:5:true", "9:8:true"], delimiter = ':')
    internal fun `점수 비교`(i1: Int, i2: Int, expected: Boolean) {
        val score = Score(i1)
        assertThat(score.isBiggerThanOrEquals(i2)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 10])
    internal fun `0~9 범위를 벗어나는 점수 생성불가`(value: Int) {
        assertThrows<IllegalArgumentException> { Score(value) }
    }
}
