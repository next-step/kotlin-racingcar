package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun 이름_붙인_인자() {
        val people = listOf(
            Person("김기표", 30, "글렌"),
            Person("김기표", 30, nickname = "글렌"),
            Person(name = "김기표", age = 30, nickname = "글렌")
        )

        assertThat(people[0].name).isEqualTo("김기표")
        assertThat(people[1].name).isEqualTo("김기표")
        assertThat(people[2].name).isEqualTo("김기표")
    }

    @Test
    fun `널 타입`() {
        val person = Person("김기표", 30, null)
        assertThat(person.name).isEqualTo("김기표")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김기표", 30)
        assertThat(person.name).isEqualTo("김기표")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("김기표")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김기표", 30)
        val person2 = Person("김기표", 30)
        assertThat(person1).isEqualTo(person2)
    }
}