package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest{
    @Test
    internal fun `랜덤값이 4이상일 때 전진이 나온다`() {
       assertThat(RacingGame.isMove(4)).isEqualTo(1)
    }

    @Test
    internal fun `랜덤값이 4이상일 때는 전진하지 않는다`() {
        assertThat(RacingGame.isMove(3)).isEqualTo(0)
    }
}