package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `빈 문자열 입력 예외`(inputString: String) {
        assertThrows<IllegalArgumentException> {
            InputView.inputCarsName(inputString)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["가나다라", "@#!", "11 가나다라"])
    fun `숫자가 아닌 값 입력 예외`(inputString: String) {
        assertThrows<IllegalArgumentException> {
            InputView.inputNumberOfMoves(inputString)
        }
    }

    @Test
    fun `차량 이름 입력`() {
        val carsName = "자동차1,자동차2,자동차3,자동차4,자동차5"
        val actual = InputView.inputCarsName(carsName)
        assertThat(actual).isEqualTo(carsName)
    }

    @Test
    fun `이동 횟수 입력`() {
        val numberOfMoves = "5"
        val actual = InputView.inputNumberOfMoves(numberOfMoves)
        assertThat(actual).isEqualTo(numberOfMoves.toInt())
    }
}
