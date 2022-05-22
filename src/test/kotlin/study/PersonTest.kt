package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        var people = listOf(
            Person("서정국", 33, "꾸기"),
            Person("서정국", 33, nickname = "꾸기"),
            Person(name = "서정국", age = 33, nickname = "꾸기")
        )
        assertThat(people[0].name).isEqualTo("서정국")
        assertThat(people[1].name).isEqualTo("서정국")
        assertThat(people[2].name).isEqualTo("서정국")
    }

    @Test
    fun `널 타입`() {
        val person = Person("서정국", 33, null)
        assertThat(person.name).isEqualTo("서정국")
        assertThat(person.age).isEqualTo(33)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("서정국", 33)
        assertThat(person.name).isEqualTo("서정국")
        assertThat(person.age).isEqualTo(33)
        assertThat(person.nickname).isEqualTo("서정국")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("서정국", 33)
        val person2 = Person("서정국", 33)
        assertThat(person1).isEqualTo(person2)
    }
}
