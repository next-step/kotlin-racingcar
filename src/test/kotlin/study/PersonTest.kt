package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "이재윤", age = 29, nickname = "ggam-nyang")
        assertThat(actual.name).isEqualTo("이재윤")
        assertThat(actual.age).isEqualTo(29)
        assertThat(actual.nickname).isEqualTo("ggam-nyang")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "이재윤", age = 29, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "이재윤", age = 29)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "이재윤", age = 29, nickname = "ggam-nyang")
        val person2 = Person(name = "이재윤", age = 29, nickname = "ggam-nyang")
        assertThat(person1).isEqualTo(person2)
    }
}
