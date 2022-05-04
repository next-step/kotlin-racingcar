package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("김종성", 27, "리즐"),
            Person("김종성", 27, nickname = "리즐"),
            Person(name = "김종성", age = 27, nickname = "리즐")
        )
        assertThat(people[0].name).isEqualTo("김종성")
        assertThat(people[1].name).isEqualTo("김종성")
        assertThat(people[2].name).isEqualTo("김종성")
    }

    @Test
    fun `널 타입`() {
        val person = Person("김종성", 27, null)

        assertThat(person.name).isEqualTo("김종성")
        assertThat(person.age).isEqualTo(27)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김종성", 27)

        assertThat(person.name).isEqualTo("김종성")
        assertThat(person.age).isEqualTo(27)
        assertThat(person.nickname).isEqualTo("김종성")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김종성", 27)
        val person2 = Person("김종성", 27)

        assertThat(person1).isEqualTo(person2)
    }
}
