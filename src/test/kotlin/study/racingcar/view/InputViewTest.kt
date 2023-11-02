package study.racingcar.view

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.racingcar.application.Reader

class InputViewTest {

    // TODO-review : 외부의존성인 Input 에 대해서 테스트 코드를 작성하기 위해 사용한 방식이 적합한지 코멘트 부탁드립니다!
    //  - MockReader 클래스 구현
    //  - null & empty 는 fun inputString() 에서 검증하고 있기 때문에, 테스트 코드 작성 필요 x
    class MockReader(private val input: String) : Reader {
        override fun read(): String? {
            return input
        }
    }

    @ValueSource(strings = ["123", "456", "789"])
    @ParameterizedTest
    fun `mock reader 를 사용했을때, 입력값을 받아올 수 있는지 확인`(input: String) {
        // given
        val reader = MockReader(input)

        // when
        val result: Int = InputView(reader).inputNumber("Enter a number: ")

        // then
        assert(result.toString() == input)
    }
}
