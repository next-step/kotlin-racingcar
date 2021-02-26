package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PersonDataTest {
    @Test
    internal fun `data class 테스트`() {
        val person1 = PersonData(name = "김연태", age = 30)
        val person2 = PersonData(name = "김연태", age = 30)
        assertThat(person1).isEqualTo(person2)
    }
}
