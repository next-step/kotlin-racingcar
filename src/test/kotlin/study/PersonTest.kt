package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        Person("홍길동", 20, "Hong")
        Person(name = "홍길동", age = 20, nickname = "Hong")

        val actual = Person(name = "홍길동", nickname = "Hong", age = 20)
        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.nickname).isEqualTo("Hong")
        assertThat(actual.age).isEqualTo(20)
    }

    @Test
    internal fun `널 타입`() {
        val actual = Person("홍길동", 20, null)

        assertThat(actual.nickname).isNull()
    }

    @Test
    internal fun `기본 인자`() {
        val actual = Person(name = "홍길동", age = 20)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    internal fun `데이터 클래스`() {
        val person1 = Person("홍길동", 20, "Hong")
        val person2 = Person("홍길동", 20, "Hong")

        assertThat(person1).isEqualTo(person2)
    }
}
