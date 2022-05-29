package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("민우", 19, "메이슨"),
            Person("민우", 19, nickname = "메이슨"),
            Person(name = "민우", nickname = "메이슨", age = 19)
        )
        assertThat(people[0].name).isEqualTo("민우")
        assertThat(people[1].name).isEqualTo("민우")
        assertThat(people[2].name).isEqualTo("민우")
    }

    @Test
    fun `널 타입`() {
        val person = Person("민우", 19, null)

        assertThat(person.name).isEqualTo("민우")
        assertThat(person.age).isEqualTo(19)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("민우", 19)

        assertThat(person.name).isEqualTo("민우")
        assertThat(person.age).isEqualTo(19)
        assertThat(person.nickname).isEqualTo("민우")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("민우", 19)
        val person2 = Person("민우", 19)

        assertThat(person1).isEqualTo(person2)
    }
}
