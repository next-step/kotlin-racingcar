package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "이수민", nickname = "터너", age = 30)

        assertThat(actual.name).isEqualTo("이수민")
        assertThat(actual.nickname).isEqualTo("터너")
        assertThat(actual.age).isEqualTo(30)
    }

    @Test
    fun `널 타입`() {
        val actual = Person("이수민", 30, null)

        assertThat(actual.name).isEqualTo("이수민")
        assertThat(actual.nickname).isNull()
        assertThat(actual.age).isEqualTo(30)
    }

    @Test
    fun `기본 인자`() {
        val actual = Person("이수민", 30)

        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("이수민", 30, "터너")
        val person2 = Person("이수민", 30, "터너")

        assertThat(person1).isEqualTo(person2)
    }
}
