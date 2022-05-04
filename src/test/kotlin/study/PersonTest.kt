package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("이승주", 30, "알버스"),
            Person("이승주", 30, nickname = "알버스"),
            Person(name = "이승주", nickname = "알버스", age = 30)
        )

        assertThat(people[0].name).isEqualTo("이승주")
        assertThat(people[1].name).isEqualTo("이승주")
        assertThat(people[2].name).isEqualTo("이승주")
    }

    @Test
    fun `널 타입`() {
        val person = Person("이승주", 30, null)

        assertThat(person.name).isEqualTo("이승주")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("이승주", 30)

        assertThat(person.name).isEqualTo("이승주")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("이승주")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("이승주", 30)
        val person2 = Person("이승주", 30)

        assertThat(person1).isEqualTo(person2)
    }
}
