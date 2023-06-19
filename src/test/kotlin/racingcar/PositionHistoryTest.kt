package racingcar

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class PositionHistoryTest {
    @Test
    fun `position은 1이상이어야 한다`() {
        shouldThrow<IllegalArgumentException> {
            PositionHistory(
                listOf(
                    "test1" to 0,
                    "test2" to 1,
                    "test3" to 2,
                    "test4" to 3
                )
            )
        }
    }
}
