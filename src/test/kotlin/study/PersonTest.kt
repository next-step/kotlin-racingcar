package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {
    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("남동민", 28, "도미닉"),
            Person("남동민", 28, nickname = "도미닉"),
            Person(name = "남동민", nickname = "도미닉", age = 28)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("남동민")
            assertThat(it.age).isEqualTo(28)
            assertThat(it.nickname).isEqualTo("도미닉")
        }
    }

    @Test
    fun `nullable types`() {
        val person = Person("박재성", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("박재성") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `default arguments`() {
        val person = Person("박재성")
        assertAll(
            { assertThat(person.name).isEqualTo("박재성") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("박재성", 29, "제이슨")
        val person2 = Person("박재성", 29, "제이슨")
        assertThat(person1).isEqualTo(person2)
    }
}
