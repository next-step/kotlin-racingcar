package racingcar.utils

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputUtilsTest {
    @Test
    fun convertStringLineToNames() {
        // given
        val readLine = "Tesla, Waymo, ZOOX"

        // when
        val names: List<String> = InputUtils.convertToNames(readLine)

        // then
        assertThat(names).hasSize(3)
    }

    @Test
    internal fun convertToNamesWhenNull() {
        // given
        val readLine = null

        // when
        assertThatThrownBy { InputUtils.convertToNames(readLine) }
            .isInstanceOf(NullPointerException::class.java)
    }
}
