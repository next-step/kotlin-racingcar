package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("이소연", 29, "우주"),
            Person("이소연", 29, nickname = "우주"),
            Person(name = "이소연", age = 29, nickname = "우주")
        )

        assertThat(people[0].name).isEqualTo("이소연")
        assertThat(people[1].name).isEqualTo("이소연")
        assertThat(people[2].name).isEqualTo("이소연")
    }

    @Test
    fun `널 타입`() {
        val person = Person("이소연", 29, null)
        assertThat(person.name).isEqualTo("이소연")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("이소연", 29)
        assertThat(person.name).isEqualTo("이소연")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("이소연")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("이소연", 29)
        val person2 = Person("이소연", 29)
        assertThat(person1).isEqualTo(person2)
    }
}