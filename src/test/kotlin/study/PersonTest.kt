package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun test() {
        val person = Person(name = "Alice", 20, nickname = "Ali")
        assertThat(person.name).isEqualTo("Alice")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("Ali")
    }

    @Test
    fun `널 타입`() {
        val person = Person("Alice", 20, null)
        assertThat(person.name).isEqualTo("Alice")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("Alice", 20)
        assertThat(person.name).isEqualTo("Alice")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("Alice")
    }

    @Test
    fun `copy`() {
        val person = Person(name = "Alice", 20, nickname = "Ali")
        assertThat(person.nickname).isEqualTo("Ali")
        val actual = person.copy(nickname = "Alice")
        assertThat(actual.name).isEqualTo("Alice")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("Alice")
    }
}