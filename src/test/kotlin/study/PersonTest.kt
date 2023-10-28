package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual: Person = Person(name = "Lim JunYeong", age = 21, nickname = "JunYeong")
        assertThat(actual.name).isEqualTo("Lim JunYeong")
        assertThat(actual.age).isEqualTo(21)
        assertThat(actual.nickname).isEqualTo("JunYeong")
    }

    @Test
    fun `널 타입`() {
        val actual: Person = Person(name = "Lim JunYeong", age = 21, nickname = null)
        assertThat(actual.name).isEqualTo("Lim JunYeong")
        assertThat(actual.age).isEqualTo(21)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual: Person = Person(name = "Lim JunYeong", age = 21)
        assertThat(actual.name).isEqualTo("Lim JunYeong")
        assertThat(actual.age).isEqualTo(21)
        assertThat(actual.nickname).isEqualTo("Lim JunYeong")
    }

    @Test
    fun `데이터 클래스`() {
        val person1: Person = Person(name = "Lim JunYeong", age = 21)
        val person2: Person = Person(name = "Lim JunYeong", age = 21)
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `copy`() {
        val person: Person = Person("Lim JunYeong", 21)
        assertThat(person.nickname).isEqualTo("Lim JunYeong")

        val actual: Person = person.copy(nickname = "JunYeong")
        assertThat(actual.name).isEqualTo("Lim JunYeong")
        assertThat(actual.age).isEqualTo(21)
        assertThat(actual.nickname).isEqualTo("JunYeong")
    }
}
