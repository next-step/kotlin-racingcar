package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {

    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("김진억", 39, "제이든"),
            Person("김진억", 39, nickname = "제이든"),
            Person(name = "김진억", nickname = "제이든", age = 39)
        )

        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("김진억")
            assertThat(it.age).isEqualTo(39)
            assertThat(it.nickname).isEqualTo("제이든")
        }
    }

    @Test
    fun `nullable types`() {
        val person = Person("김진억", null, null)

        assertAll(
            { assertThat(person.name).isEqualTo("김진억") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `default arguments`() {
        val person = Person("김진억")
        assertAll(
            { assertThat(person.name).isEqualTo("김진억") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }
}
