package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름_붙인_인자`() {
        val people = listOf(
            Person("이인동", 30, "austen.lee"),
            Person("이인동", 30, nickname = "austen.lee"),
            Person(name = "이인동", age = 30, nickname = "austen.lee")
        )

        assertThat(people[0].name).isEqualTo("이인동"
        )
        assertThat(people[1].name).isEqualTo("이인동")
        assertThat(people[2].name).isEqualTo("이인동")
    }

    @Test
    fun `널 타입`() {
        val person = Person("이인동", 30, null)
        assertThat(person.name).isEqualTo("이인동")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("이인동", 30)
        assertThat(person.name).isEqualTo("이인동")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("이인동")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("이인동", 30)
        val person2 = Person("이인동", 30)
        assertThat(person1).isEqualTo(person2)
    }
}