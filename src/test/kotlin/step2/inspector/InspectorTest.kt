package step2.inspector

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

// Todo : JUnit 끝나면 Kotest로도 만들어 보자.
class InspectorTest {
    @Test
    fun `null 여부 검사`() {
        Assertions.assertThatThrownBy {
            val expression: String? = null
            mustNot {
                expression == null
            }
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}