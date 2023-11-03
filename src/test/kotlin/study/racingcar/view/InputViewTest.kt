package study.racingcar.view

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.racingcar.application.MockReader
import study.racingcar.application.Reader

class InputViewTest {

    @ValueSource(strings = ["123", "456", "789"])
    @ParameterizedTest
    fun `mock reader 를 사용했을때, 입력값을 받아올 수 있는지 확인`(input: String) {
        // given
        val reader = MockReader("", input)

        // when
        val result: Int = InputView(reader).inputNumber("Enter a number: ")

        // then
        assert(result.toString() == input)
    }
}
