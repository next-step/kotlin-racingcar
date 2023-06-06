package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val personCatsbi = Person(name = "hansol", age = 36, nickname = "catsbi")

        assertAll(
            { assertThat(personCatsbi.name).isEqualTo("hansol") },
            { assertThat(personCatsbi.age).isEqualTo(36) },
            { assertThat(personCatsbi.nickname).isEqualTo("catsbi") }
        )
    }

    @Test
    fun `널 타입`() {
        val person = Person("hansol", 33, null)

        assertAll(
            { assertThat(person.name).isEqualTo("hansol") },
            { assertThat(person.age).isEqualTo(33) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "hansol", age = 33)

        assertAll(
            { assertThat(person.name).isEqualTo("hansol") },
            { assertThat(person.age).isEqualTo(33) },
            { assertThat(person.nickname).isEqualTo("Guest") }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("홍길동", 20, "Hong")
        val person2 = Person("홍길동", 20, "Hong")

        assertThat(person1).isEqualTo(person2)
    }
}
