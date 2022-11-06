package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MovableTest {

    @Test
    fun `4 미만의 값(0)은 전진할 수 없다`() {
        assertThat(Movable().canGo(0)).isEqualTo(false)
    }

    @Test
    fun `4 미만의 값(3)은 전진할 수 없다`() {
        assertThat(Movable().canGo(3)).isEqualTo(false)
    }

    @Test
    fun `4이상의 값(4)은 전진할 수 있다`() {
        assertThat(Movable().canGo(4)).isEqualTo(true)
    }

    @Test
    fun `4이상의 값(5)은 전진할 수 있다`() {
        assertThat(Movable().canGo(5)).isEqualTo(true)
    }

    @Test
    fun `4이상의 값(9)은 전진할 수 있다`() {
        assertThat(Movable().canGo(9)).isEqualTo(true)
    }
}
