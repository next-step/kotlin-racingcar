package racingcar

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class PositionHistoryTest {
    @Test
    fun `position은 1이상이어야 한다`() {
        shouldThrow<IllegalArgumentException> {
            PositionHistory(
                listOf(CarPositionSnapshot("test", 0))
            )
        }
    }
}
