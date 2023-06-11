package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "최환", age = 32, nickname = "파블로")
        assertThat(actual.name).isEqualTo("최환")
        assertThat(actual.age).isEqualTo(32)
        assertThat(actual.nickname).isEqualTo("파블로")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "최환", age = 31, nickname = null)
        val actual2 = Person(name = "최환", age = 31)
        assertThat(actual.nickname).isNull()
        assertThat(actual2.nickname).isNotNull()
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("최환", 20, "Choi")
        val person2 = Person("최환", 20, "Choi")
    }
}
