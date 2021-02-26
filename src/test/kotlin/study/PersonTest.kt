package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "이태훈", age = 10, nickname = "thxwelchs")
        assertThat(person.name).isEqualTo("이태훈")
        assertThat(person.age).isEqualTo(10)
        assertThat(person.nickname).isEqualTo("thxwelchs")
    }

    @Test
    fun `널 타입`() {
        val person = Person("이태훈", 20, null)
        assertAll(
            { assertThat(person.nickname).isNull() },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.name).isEqualTo("이태훈") }
        )
    }

    @Test
    fun `기본 인자`() {
        val person = Person("이태훈", 20)
        assertAll(
            { assertThat(person.nickname).isEqualTo("이태훈") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.name).isEqualTo("이태훈") }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("이태훈", 20, "thxwelchs")
        val person2 = Person("이태훈", 20, "thxwelchs")
        assertThat(person1).isEqualTo(person2)
    }
}
