package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayInputStream

class RacingInputReceiverTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "'5\n3'  ,    5, 3",
            "'3\n3'  ,    3, 3",
            "'13\n1' ,   13, 1"
        ]
    )
    fun `사용자의 입력이 들어오면, 입력을 리턴한다`(input: String, carNumber: Int, moveCount: Int) {
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        assertThat(RacingInputReceiver().receive()).isEqualTo(UserInput(carNumber, moveCount))
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "    ", "자동차10대", "지나가던강아지 한마리", "IDontKnowKorean"])
    fun `잘못된 사용자의 입력이 들어오면, IllegalArgumentException 예외가 발생한다`(input: String) {
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        assertThrows<IllegalArgumentException> {
            RacingInputReceiver().receive()
        }
    }
}
