package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {
    val name = "김철수"
    val age = 20
    val nickname = "아이언워터"
    @Test
    internal fun `named arguments`() {
        val people = listOf(
            Person(name, age, nickname),
            Person(name, age, nickname = nickname),
            Person(name = name, nickname = nickname, age = age),
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo(name)
            assertThat(it.age).isEqualTo(age)
            assertThat(it.nickname).isEqualTo(nickname)
        }
    }

    @Test
    internal fun `nullable types`() {
        val person = Person(name, null, null)
        assertAll(
            { assertThat(person.name).isEqualTo(name) },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() },
        )
    }

    @Test
    internal fun `default arguments`() {
        val person = Person(name)
        assertAll(
            { assertThat(person.name).isEqualTo(name) },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() },
        )
    }

    @Test
    internal fun `data classes`() {
        val person1 = Person(name, age, nickname)
        val person2 = Person(name, age, nickname)
        assertThat(person1).isEqualTo(person2)
    }
}
