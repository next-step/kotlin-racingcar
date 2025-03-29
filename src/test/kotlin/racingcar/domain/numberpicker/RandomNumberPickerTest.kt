package racingcar.domain.numberpicker

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest

class RandomNumberPickerTest {
    @RepeatedTest(10)
    fun `Number should be between 0 and 9`() {
        val randomNumberPicker = RandomNumberPicker()

        val actual = randomNumberPicker.getNumber()
        val expectedStart = 0
        val expectedEnd = 9

        assertThat(actual).isBetween(expectedStart, expectedEnd)
    }
}
