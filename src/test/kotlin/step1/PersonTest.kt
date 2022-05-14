package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("장재주", 32, "제이"),
            Person("장재주", 32, nickname = "제이"),
            Person(name = "장재주", age = 32, nickname = "제이")
        )

        assertThat(people[0].name).isEqualTo("장재주")
        assertThat(people[1].name).isEqualTo("장재주")
        assertThat(people[2].name).isEqualTo("장재주")
    }

    @Test
    fun `널 타입`() {
        val person = Person("장재주", 32, null)
        assertThat(person.name).isEqualTo("장재주")
        assertThat(person.age).isEqualTo(32)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("장재주", 32)

        assertThat(person.name).isEqualTo("장재주")
        assertThat(person.age).isEqualTo(32)
        assertThat(person.nickname).isEqualTo("장재주")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("장재주", 32)
        val person2 = Person("장재주", 32)
        assertThat(person1).isEqualTo(person2)
    }
}
