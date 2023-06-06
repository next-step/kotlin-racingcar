package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "김송이", age = 24, nickname = "song2")

        assertThat(actual.name).isEqualTo("김송이")
        assertThat(actual.nickname).isEqualTo("song2")
        assertThat(actual.age).isEqualTo(24)
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "김송이", age = 24, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "김송이", age = 24)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("홍길동", 20, "Hong")
        val person2 = Person("홍길동", 20, "Hong")

        assertThat(person1).isEqualTo(person2)
    }
}
