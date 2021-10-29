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
            InputView(inputString)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["가나다라", "@#!", "11 가나다라"])
    fun `숫자가 아닌 값 입력 예외`(inputString: String) {
        assertThrows<IllegalArgumentException> {
            InputView(inputString)
        }
    }

    @Test
    fun `차량수 입력`() {
        val numberOfCars = "3"
        val actual = InputView(numberOfCars).inputNumberOfNewCars()
        assertThat(actual).isEqualTo(numberOfCars.toInt())
    }

    @Test
    fun `이동 횟수 입력`() {
        val numberOfMoves = "5"
        val actual = InputView(numberOfMoves).inputNumberOfMoves()
        assertThat(actual).isEqualTo(numberOfMoves.toInt())
    }
}
