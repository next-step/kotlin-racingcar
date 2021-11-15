package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnerNamesTest {

    @Test
    fun `우승자 이름 합치기`() {
        // given
        val names = listOf("자동차1", "자동차2", "자동차3")

        // when
        val actual = WinnerNames.combineWinnerNames(names)

        // then
        assertThat(actual).isEqualTo("자동차1, 자동차2, 자동차3")
    }
}
