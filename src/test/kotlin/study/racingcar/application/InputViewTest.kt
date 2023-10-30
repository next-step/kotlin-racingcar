package study.racingcar.application

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class InputViewTest {

    @Test
    @DisplayName("stdin reader 를 사용했을때, 입력값을 받아올 수 있는지 확인")
    fun getInput() {
        // given
        val reader = mock<Reader>()

        // when
        whenever(reader.read()).thenReturn("123")
        val result: Int = InputView(reader).inputNumber("Enter a number: ")

        // then
        assert(result == 123)
    }
}
