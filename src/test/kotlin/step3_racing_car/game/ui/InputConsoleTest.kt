package step3_racing_car.game.ui

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

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
        assertThat(InputConsole(mockReceiver).run()).isEqualTo(Pair(0, 0))
    }

    @ParameterizedTest
    @NullAndEmptySource
    @CsvSource(
        "0, -1, a, b ,$"
    )
    fun exceptionTest(input: String?) {
        assertThatThrownBy {
            // given
            mockReceiver.answer = input
            // when
            InputConsole(mockReceiver).run()
        } // then
            .isInstanceOf(java.lang.IllegalArgumentException::class.java)
    }
}
