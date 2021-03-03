package racingcar.utils

import org.assertj.core.api.Assertions.assertThat
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
}
