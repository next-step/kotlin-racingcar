package study

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.random.Random

class RandomTest {
    @ParameterizedTest
    @ValueSource(ints = [10, 100, 1000])
    fun `랜덤함수에서 0~9 사이의 수가 나오는지`(count: Int) {
        for (i in 0..count) {
            val v = Random.nextInt(9)
            Assertions.assertThat(v).isBetween(0, 9)
        }
    }
}
