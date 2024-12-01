package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.ui.RaceResultGenerator

class RaceResultGeneratorTest {
    @Test
    fun `자동차 목록을 받아 각 자동차의 position 에 따라 결과 문자열을 생성한다`() {
        val firstCarName = "김씨"
        val secondCarName = "박씨"
        val thirdCarName = "이씨"

        val cars =
            listOf(
                Car(position = 1, name = firstCarName),
                Car(position = 2, name = secondCarName),
                Car(position = 3, name = thirdCarName),
            )

        val result = RaceResultGenerator.generate(cars)

        assertThat(result).isEqualTo(
            """
            $firstCarName : -
            $secondCarName : --
            $thirdCarName : ---
            
            """.trimIndent(),
        )
    }
}
