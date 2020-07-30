package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.random.nextInt

class RandomStudyTest {

    @Test
    fun `랜덤의 IntRange는 해당 범위의 값이 다 나온다`() {
        // then
        for (i in 0..10000) {
            assertThat(Random.nextInt(0..9)).isBetween(0, 9)
        }
    }
}
