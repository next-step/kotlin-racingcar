package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("유인근", 27, "에이든"),
            Person("유인근", 27, nickname = "에이든"),
            Person(name = "유인근", nickname = "에이든", age = 27)
        )

        assertThat(people[0].name).isEqualTo("유인근")
        assertThat(people[1].name).isEqualTo("유인근")
        assertThat(people[2].name).isEqualTo("유인근")
    }

    @Test
    fun `널 타입`() {
        val person = Person("유인근", 27, null)

        assertThat(person.name).isEqualTo("유인근")
        assertThat(person.age).isEqualTo(27)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("유인근", 27)

        assertThat(person.name).isEqualTo("유인근")
        assertThat(person.age).isEqualTo(27)
        assertThat(person.nickname).isEqualTo("유인근")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("유인근", 27)
        val person2 = Person("유인근", 27)

        assertThat(person1).isEqualTo(person2)
    }
}
