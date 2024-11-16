package race

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.provider.EmptySource

class NameTest {
    @Test
    fun `5자 초과시 예외발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            Name("1234567")
        }
    }

    @Test
    @EmptySource
    fun `빈 문자열 입력시 예외발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            Name("")
        }
    }
}
