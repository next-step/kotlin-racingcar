package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("이요한", 28, "요한"),
            Person("이요한", 28, nickname = "요한"),
            Person(name = "이요한", age = 28, nickname = "요한")
        )
        assertThat(people[0].name).isEqualTo("이요한")
        assertThat(people[1].name).isEqualTo("이요한")
        assertThat(people[2].name).isEqualTo("이요한")
    }

    @Test
    fun `널 타입`() {
        val person = Person("이요한", 28, null)

        assertThat(person.name).isEqualTo("이요한")
        assertThat(person.age).isEqualTo(28)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("이요한", 28)

        assertThat(person.name).isEqualTo("이요한")
        assertThat(person.age).isEqualTo(28)
        assertThat(person.nickname).isEqualTo("이요한")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("이요한", 28)
        val person2 = Person("이요한", 28)

        assertThat(person1).isEqualTo(person2)
    }
}
