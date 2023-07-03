package racingcar.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RoundHistoryTest {

    @Test
    fun maxPositionCarInfos() {
        val carInfos = listOf(
            CarInfo("a", 1),
            CarInfo("b", 2),
            CarInfo("c", 3),
            CarInfo("d", 3),
        )
        val roundHistory = RoundHistory(1, carInfos)

        val maxPositionCarInfos = roundHistory.maxPositionCarInfos()

        maxPositionCarInfos shouldBe listOf(
            CarInfo("c", 3),
            CarInfo("d", 3),
        )
    }
}
