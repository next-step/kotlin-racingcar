package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceResultTest {
    @Test
    fun `우승자를 반환한다`() {
        val raceResult =
            RaceResult(
                listOf(
                    RaceRound(
                        // data class RaceRound(val round: List<Pair<String, Int>>)
                        listOf(
                            "a" to 1,
                            "b" to 2,
                            "c" to 3,
                        ),
                    ),
                    RaceRound(
                        listOf(
                            "a" to 2,
                            "b" to 3,
                            "c" to 4,
                        ),
                    ),
                ),
            )

        assertThat(raceResult.winners).containsExactly("c")
    }

    @Test
    fun `우승자가 여러명일 경우 모두 반환한다`() {
        val raceResult =
            RaceResult(
                listOf(
                    RaceRound(
                        listOf(
                            "a" to 1,
                            "b" to 2,
                            "c" to 3,
                        ),
                    ),
                    RaceRound(
                        listOf(
                            "a" to 1,
                            "b" to 5,
                            "c" to 5,
                        ),
                    ),
                ),
            )

        assertThat(raceResult.winners).containsExactly("b", "c")
    }
}
