package racingcar.strategy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FairStrategyTest {

    @Test
    fun getCanMove() {
        assertThat(FairStrategy().canMove).isTrue()
    }
}
