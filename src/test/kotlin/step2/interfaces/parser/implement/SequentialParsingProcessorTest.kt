package step2.interfaces.parser.implement

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import step2.application.parser.ParsingProcessor
import step2.application.parser.implement.SequentialParsingProcessor

internal class SequentialParsingProcessorTest {

    private val parsingProcessor: ParsingProcessor = SequentialParsingProcessor()

    @ParameterizedTest
    @ValueSource(strings = ["1 + 1", "2 * 5", "3 - 4"])
    fun `이항 연산자를 입력 모델로 변환한다`(expression: String) {
        val inputOperationCommandList = parsingProcessor.proceed(expression)
        assertThat(inputOperationCommandList.size).isEqualTo(2)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 ! 1", "2 _ 5", "0 1 4"])
    fun `연산자에 에러가 있으면 IllegalArgumentException 발생시킨다`(expression: String) {
        assertThrows<IllegalArgumentException> { parsingProcessor.proceed(expression) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["( + 1", "2 - !", ":0 * 4"])
    fun `숫자에 에러가 있으면 NumberFormatException 발생시킨다`(expression: String) {
        assertThrows<NumberFormatException> { parsingProcessor.proceed(expression) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0 +", "2 - 1 + ", "5 - 4 + 1 /"])
    fun `파싱된 값이 홀수가 아니면 오류가 발생한다`(expression: String) {
        assertThrows<IllegalStateException> { parsingProcessor.proceed(expression) }
    }
}
