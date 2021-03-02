package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.random.Random

class RandomTest {
    @Test
    fun `0부터 9사이의 랜덤 값을 생성한다`() {
        val random = Random.nextInt(0, 10)

        assertAll(
            { assertThat(random).isLessThan(10) },
            { assertThat(random).isGreaterThan(0) }
        )
    }
}
