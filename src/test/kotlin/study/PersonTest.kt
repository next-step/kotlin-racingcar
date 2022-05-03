package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("임석호", 29, "d000l"),
            Person("임석호", 29, nickname = "d000l"),
            Person(name = "임석호", nickname = "d000l", age = 29)
        )
        assertThat(people[0].name).isEqualTo("임석호")
        assertThat(people[1].name).isEqualTo("임석호")
        assertThat(people[2].name).isEqualTo("임석호")
    }

    @Test
    fun `널 타입`() {
        val person = Person("임석호", null, null)

        assertThat(person.name).isEqualTo("임석호")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("임석호", 29)

        assertThat(person.name).isEqualTo("임석호")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("d000l")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("임석호", 29, "d000l")
        val person2 = Person("임석호", 29, "d000l")
        assertThat(person1).isEqualTo(person2)
    }
}