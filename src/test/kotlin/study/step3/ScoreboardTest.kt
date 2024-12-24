package study.step3

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import study.step3.entity.Scoreboard

class ScoreboardTest {
    private lateinit var scoreboard: Scoreboard

    @BeforeEach
    fun setUp() {
        scoreboard = Scoreboard()
    }

    @Test
    fun `최고점이 1명이면 승자는 1명이다`() {
        scoreboard.add(
            listOf(
                Scoreboard.Item(title = "a", score = 3),
                Scoreboard.Item(title = "b", score = 1),
                Scoreboard.Item(title = "c", score = 2),
            )
        )

        val winnerNames = scoreboard.winnerNames

        winnerNames.size shouldBe 1
    }

    @Test
    fun `최고점이 2명이면 승자는 2명이다`() {
        scoreboard.add(
            listOf(
                Scoreboard.Item(title = "a", score = 3),
                Scoreboard.Item(title = "b", score = 1),
                Scoreboard.Item(title = "c", score = 3),
            )
        )

        val winnerNames = scoreboard.winnerNames

        winnerNames.size shouldBe 2
    }
}
