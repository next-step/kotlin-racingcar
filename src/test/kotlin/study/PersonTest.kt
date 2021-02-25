package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "김동규", age = 20, nickname = "kmdngyu")
        assertThat(person.name).isEqualTo("김동규")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("kmdngyu")
    }

    @Test
    fun `널 타입`() {
        val person = Person("김동규", 20, null)
        assertAll(
            { assertThat(person.name).isEqualTo("김동규") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김동규", 20)
        assertAll(
            { assertThat(person.name).isEqualTo("김동규") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isEqualTo("김동규") }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김동규", 20, "kmdngyu")
        val person2 = Person("김동규", 20, "kmdngyu")
        assertThat(person1).isEqualTo(person2)
    }
}
