package racingcar.domain.move

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.random.Random

class RandomMovingStrategyTest {
    @Test
    fun randomTest() {
        val nextInt = Random.nextInt(10)

        assertThat(nextInt).isLessThan(10).isGreaterThan(0)
    }
}
