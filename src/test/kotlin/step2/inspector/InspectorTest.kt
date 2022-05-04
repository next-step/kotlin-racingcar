package step2.inspector

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

// Todo : JUnit 끝나면 Kotest로도 만들어 보자.
class InspectorTest {
    @ParameterizedTest
    @NullAndEmptySource
    fun `input이 null 혹은 empty인지 확인하고, null이나 empty가 맞다면 IllegalArgumentException을 던진다`(input: String?) {
        Assertions.assertThatThrownBy {
            mustNot {
                input.isNullOrEmpty()
            }
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}