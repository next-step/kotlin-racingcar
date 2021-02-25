package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {
    @Test
    internal fun `이름 붙인 인자`() {
        val person = Person(name = "남윤서", age = 20, nickname = "터틀")
        assertThat(person.name).isEqualTo("남윤서")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("터틀")
    }

    @Test
    internal fun `널 타입`() {
        val person = Person("남윤서", 20, null)
        assertAll(
            { assertThat(person.name).isEqualTo("남윤서") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    internal fun `기본 인자`() {
        val person = Person("남윤서", 20)
        assertAll(
            { assertThat(person.name).isEqualTo("남윤서") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isEqualTo("남윤서") }
        )
    }

    @Test
    internal fun `데이터 클래스`() {
        val person1 = Person("남윤서", 20, "터틀")
        val person2 = Person("남윤서", 20, "터틀")

        assertThat(person1).isEqualTo(person2)
    }
}
