package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(
            name = "김인혁",
            age = 30,
            nickname = "Aiden",
        )
        assertThat(person.name).isEqualTo("김인혁")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("Aiden")
    }

    @Test
    fun `널 타입`() {
        val person = Person(
            name = "김인혁",
            age = 30,
            nickname = null,
        )
        assertThat(person.name).isEqualTo("김인혁")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(
            name = "김인혁",
            age = 30,
        )
        assertThat(person.name).isEqualTo("김인혁")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("김인혁")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(
            name = "김인혁",
            age = 30,
        )
        val person2 = Person(
            name = "김인혁",
            age = 30,
        )
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun copy() {
        val person1 = Person(
            name = "김인혁",
            age = 30,
        )
        val person2 = person1.copy(nickname = "Aiden")
        assertThat(person2.name).isEqualTo("김인혁")
        assertThat(person2.age).isEqualTo(30)
        assertThat(person2.nickname).isEqualTo("Aiden")
        assertThat(person1.nickname).isEqualTo("김인혁")
    }
}
