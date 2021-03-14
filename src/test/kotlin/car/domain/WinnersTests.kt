package car.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnersTests {
    @Test
    fun `승리자 목록은 History 기반으로 스스로 승리인지 파악할 수 있어야 한다`() {
        val carMoveHistoryCollection = CarMoveHistoryCollection(
            listOf(
                CarMoveHistory("1번차", 3),
                CarMoveHistory("2번차", 5),
                CarMoveHistory("3번차", 2),
                CarMoveHistory("4번차", 5),
                CarMoveHistory("5번차", 1)
            )
        )

        val winners = Winners(carMoveHistoryCollection)

        assertThat(winners.winners)
            .containsExactlyInAnyOrder(
                Winner("2번차"),
                Winner("4번차")
            )
    }
}
