package racingcar.input

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PlayTimeTest {
    @DisplayName("PlayTime 생성 테스트")
    @Test
    fun `PlayTime 생성 테스트`() {
        val playTime = PlayTime(1)
        assertThat(playTime).isEqualTo(PlayTime(1))
    }

    @DisplayName("PlayTime 생성 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(ints = [0, -1])
    fun `PlayTime 생성 예외처리 테스트`(playTime: Int) {
        assertThatThrownBy { PlayTime(playTime) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("시도 횟수는 0보다 커야 합니다.")
    }
}
