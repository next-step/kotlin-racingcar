package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DefaultRandomGeneratorTest {
    private val sut = DefaultRandomGenerator()

    @Test
    fun `from 보다 크거나 같고 until 보다 작거나 같은 랜덤 수를 반환한다`() {
        // given
        val from = 10
        val until = 30

        // when

        // then
        repeat(100) {
            assertThat(sut.generate(from, until)).isBetween(from, until)
        }
    }
}
