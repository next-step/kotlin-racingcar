package racingcar.util.extension

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class ExtensionTest {

    @Test
    fun `extension 형변환 체크`() {
        assertThat("3".toInt()).isEqualTo(3)
    }
}
