package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("김성주", 29, "저스틴"),
            Person("김성주", 29, nickname = "저스틴"),
            Person(name = "김성주", age = 29, nickname = "저스틴")
        )
        assertThat(people[0].name).isEqualTo("김성주")
        assertThat(people[1].name).isEqualTo("김성주")
        assertThat(people[2].name).isEqualTo("김성주")
    }

    @Test
    fun `널 타입`() {
        val person = Person("김성주", 29, null)

        assertThat(person.name).isEqualTo("김성주")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김성주", 29)

        assertThat(person.name).isEqualTo("김성주")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("김성주")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김성주", 29)
        val person2 = Person("김성주", 29)

        assertThat(person1).isEqualTo(person2)
    }
}