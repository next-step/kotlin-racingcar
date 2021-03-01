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

        assertThat(Winner(positions).names()).containsExactly("pobi", "honux")
    }

    class Winner(private val positions: List<Positions>) {
        fun names(): List<String> {
            return positions.last()
                .sortedByDescending { it.intValue() }
                .takeIf { it.isNotEmpty() }
                ?.run {
                    winnerNames(this, first().intValue())
                } ?: emptyList()
        }

        private fun winnerNames(
            positions: List<NamedPosition>,
            mostPosition: Int
        ) = positions.takeWhile { it.intValue() >= mostPosition }
            .map { it.name.stringValue() }
    }
}
