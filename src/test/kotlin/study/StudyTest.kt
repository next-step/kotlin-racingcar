package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StudyTest {
    @Test
    fun `string isBlank test`() {
        assertThat("".isBlank()).isTrue()
        assertThat(null?.isBlank()).isNull()
        assertThat(" ".isBlank()).isTrue()
    }
}
