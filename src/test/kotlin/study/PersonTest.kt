package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("김경백", 21, "비스타"),
            Person("김경백", 21, nickname = "비스타"),
            Person(name = "김경백", age = 21, nickname = "비스타")
        )
        assertThat(people[0].name).isEqualTo("김경백")
        assertThat(people[1].name).isEqualTo("김경백")
        assertThat(people[2].name).isEqualTo("김경백")
    }

    @Test
    fun `널 타입`() {
        val person = Person("김경백", 21, null)

        assertThat(person.name).isEqualTo("김경백")
        assertThat(person.age).isEqualTo(21)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김경백", 21)

        assertThat(person.name).isEqualTo("김경백")
        assertThat(person.age).isEqualTo(21)
        assertThat(person.nickname).isEqualTo("김경백")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김경백", 21)
        val person2 = Person("김경백", 21)

        assertThat(person1).isEqualTo(person2)
    }
}
