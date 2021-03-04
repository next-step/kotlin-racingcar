package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RandomNumberGeneratorTest {

    @Test
    fun `생성 테스트`() {
        assertThat(RandomNumberGenerator().generate()).isIn((0..9).map { Number(it) })
    }
}
