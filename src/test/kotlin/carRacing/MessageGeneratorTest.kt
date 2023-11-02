package carRacing

import carRacing.enum.ErrorCode
import carRacing.view.MessageGenerator
import carRacing.view.VARIABLE_PATTERN
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.provider.CsvSource
import java.util.stream.Stream

class MessageGeneratorTest {

    @ParameterizedTest
    @ArgumentsSource(NonVariableErrorCodeEnumProvider::class)
    fun `ErrorCode에 등록된 variable이 없는 메시지를 반환한다`(errorCode: ErrorCode) {
        val messageGenerator: MessageGenerator = MessageGenerator()

        val result: String = messageGenerator.getErrorMessage(errorCode)

        assertThat(result).isEqualTo(errorCode.message)
    }

    @ParameterizedTest
    @CsvSource("0", "1", "2")
    fun `ErrorCode에 등록된 variable이 있는 메시지를 반환한다`(leftCount: String) {
        val errorCode: ErrorCode = ErrorCode.OVER_INPUT_TRY_LEFT
        val messageGenerator: MessageGenerator = MessageGenerator()

        val result: String = messageGenerator.getErrorMessage(errorCode, leftCount)

        assertThat(result).isEqualTo(errorCode.message.replace("[0]", leftCount))
    }

    @Test
    fun `ErrorCode에 등록된 variable이 있는 메시지에 variable을 주지 않으면 에러가 발생한다`() {
        val errorCode: ErrorCode = ErrorCode.OVER_INPUT_TRY_LEFT
        val messageGenerator: MessageGenerator = MessageGenerator()

        val exception: IllegalArgumentException = assertThrows {
            messageGenerator.getErrorMessage(errorCode)
        }

        assertThat(exception.message).isEqualTo(ErrorCode.MISMATCHED_VARIABLE_COUNT.message)
    }

    private class NonVariableErrorCodeEnumProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return ErrorCode.values()
                .filter { errorCode ->
                    !errorCode.message.contains(VARIABLE_PATTERN)
                }
                .map { Arguments.of(it) }
                .toList()
                .stream()
        }
    }
}
