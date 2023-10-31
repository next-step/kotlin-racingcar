package study.racingcar.application

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class InputViewTest {

    // TODO-review : 외부의존성인 Input 에 대해서 테스트 코드를 작성하기 위해 사용한 방식이 적합한지 코멘트 부탁드립니다!
    //  - Reader 인터페이스를 주입
    //  - mock 사용하는 방식
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
