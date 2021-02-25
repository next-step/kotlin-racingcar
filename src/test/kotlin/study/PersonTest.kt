package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {

    @Test
    internal fun `이름 붙인 인자`() {
        val person = Person(name = "박동욱", age = 38, nickname = "티거")
        assertThat(person.name).isEqualTo("박동욱")
        assertThat(person.age).isEqualTo(38)
        assertThat(person.nickname).isEqualTo("티거")

        val person2 = Person(nickname = "티거", name = "박동욱", age = 38)
        assertThat(person2.name).isEqualTo("박동욱")
        assertThat(person2.age).isEqualTo(38)
        assertThat(person2.nickname).isEqualTo("티거")
    }

    @Test
    internal fun `널 타입`() {
        val person = Person("박동욱", 20, null)
        assertAll(
            { assertThat(person.name).isEqualTo("박동욱") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    internal fun `기본 인자`() {
        val person = Person("박동욱", 20)
        assertAll(
            { assertThat(person.name).isEqualTo("박동욱") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isEqualTo("닉네임 없음") }
        )
    }

    @Test
    internal fun `데이터 클래스`() {
        val person1 = Person("박동욱", 20)
        val person2 = Person("박동욱", 20)
        assertThat(person1).isEqualTo(person2)
    }
}
