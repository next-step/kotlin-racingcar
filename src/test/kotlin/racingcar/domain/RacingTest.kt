package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingTest {

    @Test
    fun `레이싱 게임 시작시, 결과를 반환됩니다`() {
        val racing = Racing(listOf("pobi", "crong", "kcs")) { true }

        val result = racing.play(1)

        assertThat(result.positions)
            .containsAllEntriesOf(
                mapOf(
                    CarName("pobi") to Position(1),
                    CarName("crong") to Position(1),
                    CarName("kcs") to Position(1)
                )
            )
    }

    @Test
    fun `레이싱 게임 시작에서 , 우승자를 선출합니다`() {
        val racing = Racing(listOf("pobi", "crong", "kcs")) { true }
        racing.play(1)

        val winners = racing.findWinners()

        assertThat(winners)
            .containsExactly(
                Car(Position(1), CarName("pobi")),
                Car(Position(1), CarName("crong")),
                Car(Position(1), CarName("kcs"))
            )
    }
}
