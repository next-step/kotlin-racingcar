package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "박태임", age = 24, nickname = "태이밍")
        assertThat(actual.name).isEqualTo("박태임")
        assertThat(actual.nickname).isEqualTo("태이밍")
        assertThat(actual.age).isEqualTo(24)
    }

    @Test
    fun `널 타입`() {
        val actual = Person("박태임", 24, null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "박태임", age = 24)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "박태임", age = 24, "태임")
        val person2 = Person(name = "박태임", age = 24, "태임")
        assertThat(person1).isEqualTo(person2)
    }
}
