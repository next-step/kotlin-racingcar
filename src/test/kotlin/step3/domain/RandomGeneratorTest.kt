package step3.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.domain.random.RandomGenerator

class RandomGeneratorTest {

    private val randomGenerator = RandomGenerator()

    @Test
    fun `랜덤 값이 올바르게 생성되는지 확인한다`() {
        assertThat(randomGenerator.getIntRandom).isBetween(0, 9)
    }
}
