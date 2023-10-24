package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "이준현", age = 31, nickname = "개발인생")
        assertThat(actual.name).isEqualTo("이준현")
        assertThat(actual.age).isEqualTo(31)
        assertThat(actual.nickname).isEqualTo("개발인생")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "이준현", age = 31, nickname = null)
        assertThat(actual.name).isEqualTo("이준현")
        assertThat(actual.age).isEqualTo(31)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "이준현", age = 31)
        assertThat(actual.name).isEqualTo("이준현")
        assertThat(actual.age).isEqualTo(31)
        assertThat(actual.nickname).isEqualTo("이준현")
    }

    @Test
    fun `데이터 클래스`() {
        val actual1 = Person(name = "이준현", age = 31)
        val actual2 = Person(name = "이준현", age = 31)

        assertThat(actual1).isEqualTo(actual2)
    }

    @Test
    fun `copy`() {
        // data class 이기 때문에 가능하다.
        val person1 = Person(name = "이준현", age = 31)
        assertThat(person1.nickname).isEqualTo("이준현")

        val actual = person1.copy(nickname = "개발인생")
        assertThat(actual.name).isEqualTo("이준현")
        assertThat(actual.age).isEqualTo(31)
        assertThat(actual.nickname).isEqualTo("개발인생")
    }
}
