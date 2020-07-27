package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.RacingCarFactory.makeCars

class RacingCarFactoryTest {

    @Test
    fun `make cars`() {
        assertThat(makeCars(10).size).isEqualTo(10)
    }
}
