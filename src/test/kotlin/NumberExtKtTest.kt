import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NumberExtKtTest {

    @Test
    fun isOdd() {
        assertThat(3.isOdd()).isTrue()
        assertThat(4.isOdd()).isFalse()
    }

    @Test
    fun isInt() {
        assertThat(3.0.isInt()).isTrue()
        assertThat(3.5.isInt()).isFalse()
    }

    @Test
    fun toPrintString() {
        assertThat(4.0.toPrintString()).isEqualTo("4")
        assertThat(4.792.toPrintString()).isEqualTo("4.792")
    }

    @Test
    fun isInvalid() {
        assertThat(12.0.isInvalid()).isFalse()
        assertThat((3.0 / 0.0).isInvalid()).isTrue()
    }
}
