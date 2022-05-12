package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("최현구", 27, "현구막"),
            Person("최현구", 27, nickname = "현구막"),
            Person(
                name = "최현구",
                nickname = "현구막",
                age = 27
            )
        )

        assertThat(people[0].name).isEqualTo("최현구")
        assertThat(people[1].name).isEqualTo("최현구")
        assertThat(people[2].name).isEqualTo("최현구")
    }

    @Test
    fun `널 타입`() {
        val person = Person("최현구", 27, null)
        assertThat(person.name).isEqualTo("최현구")
        assertThat(person.age).isEqualTo(27)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("최현구", 27)
        assertThat(person.name).isEqualTo("최현구")
        assertThat(person.age).isEqualTo(27)
        assertThat(person.nickname).isEqualTo("현구막")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("최현구", 27)
        val person2 = Person("최현구", 27)
        assertThat(person1).isEqualTo(person2)
    }
}
