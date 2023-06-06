package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "이승현", age = 27, nickname = "peter")
        assertThat(actual.name).isEqualTo("이승현")
        assertThat(actual.age).isEqualTo(27)
        assertThat(actual.nickname).isEqualTo("peter")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "이승현", age = 27, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "이승현", age = 27)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "이승현", age = 27, nickname = "peter")
        val person2 = Person(name = "이승현", age = 27, nickname = "peter")
        assertThat(person1).isEqualTo(person2)
    }
}
