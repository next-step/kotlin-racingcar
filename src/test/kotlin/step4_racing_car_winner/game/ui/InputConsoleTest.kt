package step4_racing_car_winner.game.ui

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class MockReceiver : InputReceiver {
    var name: String? = "test1,test2,test3"
    var cnt: String? = "1"
    override fun receiveName(): String? {
        return name
    }

    override fun receiveGameCnt(): String? {
        return cnt
    }
}

internal class InputConsoleTest {
    val mockReceiver = MockReceiver()

    @Test
    fun runTest() {
        assertThat(InputConsole(mockReceiver).run().first).isEqualTo(mockReceiver.name)
        assertThat(InputConsole(mockReceiver).run().second).isEqualTo(mockReceiver.cnt!!.toInt())
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = ["0", "-1", "#", "$"])
    fun exceptionTest(input: String?) {
        assertThatThrownBy {
            // given
            mockReceiver.cnt = input
            // when
            InputConsole(mockReceiver).run()
        } // then
            .isInstanceOf(java.lang.IllegalArgumentException::class.java)
    }
}
