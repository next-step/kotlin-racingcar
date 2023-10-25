package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `테스트`() {
        val people = listOf(
            Person("김정우", 25, "베어"),
            Person("김정우", 25, nickname = "베어"),
            Person(name = "김정우", nickname = "베어", age = 25)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("김정우")
            assertThat(it.age).isEqualTo(25)
            assertThat(it.nickname).isEqualTo("베어")
        }
    }

    @Test
    fun `널 테스트`() {
        val person = Person("박재성", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("박재성") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }
}
