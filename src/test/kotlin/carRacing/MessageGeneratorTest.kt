package carRacing

import carRacing.Domain.MessageGenerator
import carRacing.Domain.VARIABLE_PATTERN
import carRacing.Enum.ErrorCode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class MessageGeneratorTest {

    @ParameterizedTest
    @ArgumentsSource(NonVariableErrorCodeEnumProvider::class)
    fun `ErrorCode에 등록된 variable이 없는 메시지를 반환한다`(errorCode: ErrorCode) {
        val messageGenerator: MessageGenerator = MessageGenerator()

        val result: String = messageGenerator.getErrorMessage(errorCode)

        assertThat(result).isEqualTo(errorCode.message)
    }

    private class NonVariableErrorCodeEnumProvider: ArgumentsProvider {
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