package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringTest {

    @ParameterizedTest(name = "{arguments} 가 비어있는가")
    @ValueSource(strings = [""])
    fun isEmpty(input: String) {
        assertThat(input.isEmpty()).isTrue()
    }
}
