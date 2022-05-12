package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingTest {

    @Test
    fun `레이싱 컬렉션 사이즈`() {
        val racing = Racing(Cars(listOf(Car(), Car())))

        val strategy = object : MoveStrategy {
            override fun isMove(): Boolean {
                return true
            }
        }

        racing.start(1, strategy)
        assertThat(racing.result()).size().isEqualTo(1)
    }
}
