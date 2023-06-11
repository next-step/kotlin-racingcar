package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.RandomNumberGenerator

class RandomNumberGeneratorTest {

    @Test
    fun `generate random number = start ~ end`() {
        val base: Long = 1
        val limit: Long = 100

        val generator = RandomNumberGenerator(randomBase = base, randomLimit = limit)
        val result = (1..1000).map { generator.generate() }.toSet()

        assertThat(result.any { it in base..limit }).isTrue
    }
}
