package racing_car.game.ui

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class MockReceiver : InputReceiver {
    var answer: String? = "0"
    override fun receive(): String? {
        return answer
    }
}

internal class InputConsoleTest {
    val mockReceiver = MockReceiver()

    @Test
    fun runTest() {
        // given
        mockReceiver.answer = "1"
        assertThat(InputConsole(mockReceiver).run()).isEqualTo(Pair(1, 1))
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = ["0", "-1", "#", "$"])
    fun exceptionTest(input: String?) {
        assertThrows<IllegalArgumentException> {
            mockReceiver.answer = input
            InputConsole(mockReceiver).run()
        }
    }
}
