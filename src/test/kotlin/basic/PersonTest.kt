package basic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@Suppress("SpellCheckingInspection")
class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("최우락", 43, "lazylune"),
            Person("최우락", 43, nickname = "lazylune"),
            Person(name = "최우락", nickname = "lazylune", age = 43)
        )
        assertThat(people[0].name).isEqualTo("최우락")
        assertThat(people[0].age).isEqualTo(43)
        assertThat(people[0].nickname).isEqualTo("lazylune")
    }

    @Test
    fun `널 타입`() {
        val person = Person("최우락", 43, null)
        assertThat(person.name).isEqualTo("최우락")
        assertThat(person.age).isEqualTo(43)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("최우락", 43)
        assertThat(person.name).isEqualTo("최우락")
        assertThat(person.age).isEqualTo(43)
        assertThat(person.nickname).isEqualTo("최우락")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("최우락", 43)
        val person2 = Person("최우락", 43)
        assertThat(person1).isEqualTo(person2)
    }
}