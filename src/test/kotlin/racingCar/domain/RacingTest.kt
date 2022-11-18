package racingCar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingTest {

    @Test
    fun `레이싱 게임 시작시, 결과를 반환됩니다`() {
        val racing = Racing(listOf("pobi", "crong", "kcs")) { true }

        val result = racing.play()

        assertThat(result.positions)
            .containsAllEntriesOf(
                mapOf(
                    CarName("pobi") to Position(1),
                    CarName("crong") to Position(1),
                    CarName("kcs") to Position(1)
                )
            )
    }
}
