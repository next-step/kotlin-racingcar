package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.math.pow

infix fun Int.`**`(x: Int) = toDouble().pow(x).toInt()
infix fun Long.`**`(x: Int) = toDouble().pow(x).toLong()
infix fun Float.`**`(x: Int) = pow(x)
infix fun Double.`**`(x: Int) = pow(x)

class InfixTest {
    @Test
    fun `** test`() {
        assertAll(
            { assertThat(1).isEqualTo(2 `**` 0) },
            { assertThat(4L).isEqualTo(2L `**` 2) },
            { assertThat(4F).isEqualTo(2F `**` 2) },
            { assertThat(8.0).isEqualTo(2.0 `**` 3) },
        )
    }
}
