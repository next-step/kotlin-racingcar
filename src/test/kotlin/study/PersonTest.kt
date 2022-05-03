package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("전인표", 29, "제이스"),
            Person("전인표", 29, nickname = "제이스"),
            Person(name = "전인표", age = 29, nickname = "제이스")
        )

        assertThat(people[0].name).isEqualTo("전인표")
        assertThat(people[1].name).isEqualTo("전인표")
        assertThat(people[2].name).isEqualTo("전인표")
    }

    @Test
    fun `널 타입`() {
        val person = Person("전인표", 32, null)

        assertThat(person.name).isEqualTo("전인표")
        assertThat(person.age).isEqualTo(32)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("전인표", 32)

        assertThat(person.name).isEqualTo("전인표")
        assertThat(person.age).isEqualTo(32)
        assertThat(person.nickname).isEqualTo("전인표")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("전인표", 32)
        val person2 = Person("전인표", 32)

        assertThat(person1).isEqualTo(person2)
    }
}
