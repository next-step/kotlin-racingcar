package step4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step4.domain.TryMoving

class TryMovingTest {
    @Test
    fun `카운트가 4 이상이면 움직이는데 성공한다`() {
        assertThat(TryMoving.isSuccessfullyMoved(4)).isTrue
    }

    @Test
    fun `카운트가 3 이하이면 움직이는데 실패한다`() {
        assertThat(TryMoving.isSuccessfullyMoved(3)).isFalse
    }
}
