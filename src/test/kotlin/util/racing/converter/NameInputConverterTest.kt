package util.racing.converter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class NameInputConverterTest {
    @Test
    fun `정상적으로 입력이 들어오면 이름이 convert 된다`() {
        val names = NameInputConverter.converter("pobi,crong,honux")

        assertAll(
            { assertThat(names).hasSize(3) },
            { assertThat(names[0].name).isEqualTo("pobi") },
            { assertThat(names[1].name).isEqualTo("crong") },
            { assertThat(names[2].name).isEqualTo("honux") },
        )
    }
}
