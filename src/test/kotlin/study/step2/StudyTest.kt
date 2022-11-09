package study.step2

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class StudyTest {
    @Test
    fun studyAssertThatThrownBy() {
        assertThatThrownBy {
            listOf("String one", "String two")[2]
        }.isInstanceOf(IndexOutOfBoundsException::class.java)
            .hasMessageContaining("Index 2 out of bounds for length 2")
    }

    @Test
    fun studyAssertThatExceptionOfType() {
        assertThatExceptionOfType(IndexOutOfBoundsException::class.java)
            .isThrownBy {
                listOf("String one", "String two")[2]
            }.withMessageMatching("Index 2 out of bounds for length 2")
    }
}
