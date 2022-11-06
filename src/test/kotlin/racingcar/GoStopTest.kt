package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GoStopTest {

    @Test
    fun `0이 나왔을 때 false 를 반환한다`() {
        assertThat(GoStop().canGo(0)).isEqualTo(false)
    }

    @Test
    fun `3이 나왔을 때 false 를 반환한다`() {
        assertThat(GoStop().canGo(3)).isEqualTo(false)
    }

    @Test
    fun `4이 나왔을 때 true 를 반환한다`() {
        assertThat(GoStop().canGo(4)).isEqualTo(true)
    }

    @Test
    fun `9이 나왔을 때 true 를 반환한다`() {
        assertThat(GoStop().canGo(9)).isEqualTo(true)
    }
}
