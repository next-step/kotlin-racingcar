package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayInputStream
import java.util.stream.Stream

class RacingInputReceiverTest {

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `사용자의 입력이 들어오면, 입력을 리턴한다`(input: String, carNames: List<String>, moveCount: Int) {
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        assertThat(RacingInputReceiver().receive()).isEqualTo(UserInput(carNames, moveCount))
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            " ",
            "    ",
            "이름이 너무긴 사용자,두번째로긴사람\n5",
            "자동차10대\n3",
            "지나가던강아지 한마리\n숫자가아니다.",
            "David\n숫자가 아니다."
        ]
    )
    fun `잘못된 사용자의 입력이 들어오면, IllegalArgumentException 예외가 발생한다`(input: String) {
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        assertThrows<IllegalArgumentException> {
            RacingInputReceiver().receive()
        }
    }

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments>? {
            val names = listOf("Andy", "Bruce", "Clara", "David", "Echo", "Flora")
            val stream = Stream.builder<Arguments>()
            repeat(3) {
                val randomNames = names.shuffled().drop(3)
                stream.add(Arguments.of(generateInput(randomNames, it), randomNames, it))
            }
            return stream.build()
        }

        private fun generateInput(names: List<String>, moveCount: Int): String {
            return "${names.joinToString(",")}\n$moveCount"
        }
    }
}
