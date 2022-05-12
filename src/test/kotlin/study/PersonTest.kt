package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("배수정", 29, "비비안"),
            Person("배수정", 29, nickname = "비비안"),
            Person(name = "배수정", age = 29, nickname = "비비안")
        )
        assertThat(people[0].name).isEqualTo("배수정")
        assertThat(people[1].name).isEqualTo("배수정")
        assertThat(people[2].name).isEqualTo("배수정")
    }

    @Test
    fun `널 타입`() {
        val person = Person("배수정", 29, null)

        assertThat(person.name).isEqualTo("배수정")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("배수정", 29)

        assertThat(person.name).isEqualTo("배수정")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("배수정")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("배수정", 29)
        val person2 = Person("배수정", 29)

        assertThat(person1).isEqualTo(person2)
    }
}
