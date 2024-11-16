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
                        listOf(
                            Car("a", 1),
                            Car("b", 2),
                            Car("c", 3),
                        ),
                    ),
                    RaceRound(
                        listOf(
                            Car("a", 2),
                            Car("b", 3),
                            Car("c", 4),
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
                            Car("a", 1),
                            Car("b", 2),
                            Car("c", 3),
                        ),
                    ),
                    RaceRound(
                        listOf(
                            Car("a", 2),
                            Car("b", 4),
                            Car("c", 4),
                        ),
                    ),
                ),
            )

        assertThat(raceResult.winners).containsExactly("b", "c")
    }
}
