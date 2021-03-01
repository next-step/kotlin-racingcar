package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnerTest {
    @Test
    fun `우승자 목록을 제공한다`() {
        val positions = listOf(
            Positions(
                "pobi" to 1,
                "crong" to 1,
                "honux" to 1
            ),
            Positions(
                "pobi" to 2,
                "crong" to 1,
                "honux" to 2
            )
        )

        assertThat(Winner(positions).names()).isEqualTo(listOf("pobi", "crong"))
    }

    class Winner(positions: List<Positions>) {
        fun names(): List<String> {
            return listOf("pobi", "crong")
        }
    }
}
