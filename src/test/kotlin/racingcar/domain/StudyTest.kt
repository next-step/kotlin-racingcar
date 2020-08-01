package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StudyTest {
    @Test
    fun string_length_test() {
        val str = "pikachu"

        val length = str.length

        assertThat(length).isEqualTo(7)
    }
}
