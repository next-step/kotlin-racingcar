package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.provider.ValueSource
import racing.view.RacingInputReceiver
import racing.view.UserInput
import java.util.stream.Stream

class RacingInputReceiverTest {

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `사용자의 입력이 들어오면, 입력을 리턴한다`(input: String, carNames: List<String>, moveCount: Int) {
        System.setIn(input.byteInputStream())

        assertThat(RacingInputReceiver.receive()).isEqualTo(UserInput(carNames, moveCount))
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            " ",
            "    ",
            "지나가던강아지 한마리\n숫자가아니다.",
            "David\n숫자가 아니다."
        ]
    )
    fun `잘못된 사용자의 입력이 들어오면, IllegalArgumentException 예외가 발생한다`(input: String) {
        System.setIn(input.byteInputStream())

        assertThrows<IllegalArgumentException> {
            RacingInputReceiver.receive()
        }
    }

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments>? {
            return Stream.of(
                Arguments.of("Andy,Bruce,Clara\n4", listOf("Andy", "Bruce", "Clara"), 4),
                Arguments.of("Andy\n25", listOf("Andy"), 25)
            )
        }
    }
}
