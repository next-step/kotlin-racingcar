package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputTypeTest {

    @Test
    fun operator() {
        assertThat(InputType.of("+")).isEqualTo(InputType.OPERATOR)
        assertThat(InputType.of("-")).isEqualTo(InputType.OPERATOR)
        assertThat(InputType.of("*")).isEqualTo(InputType.OPERATOR)
        assertThat(InputType.of("/")).isEqualTo(InputType.OPERATOR)
    }

    @Test
    fun number() {
        assertThat(InputType.of("43")).isEqualTo(InputType.NUMBER)
    }

    @Test
    fun none() {
        assertThat(InputType.of("x")).isEqualTo(InputType.NONE)
        assertThat(InputType.of("~")).isEqualTo(InputType.NONE)
    }
}
