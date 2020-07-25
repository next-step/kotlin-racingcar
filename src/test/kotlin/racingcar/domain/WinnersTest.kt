package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnersTest {
    @Test
    fun joinWinnersName() {
        val winners = Winners(
            listOf(
                Car("pobi", 4),
                Car("honux", 4)
            )
        )

        assertThat(winners.joinWinnersName()).isEqualTo("pobi, honux")
    }
}
