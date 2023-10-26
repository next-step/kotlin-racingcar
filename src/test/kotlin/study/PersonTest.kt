package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "홍길동", age = 30, nickname = "홍")

        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(30)
        assertThat(actual.nickname).isEqualTo("홍")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "홍길동", age = 30, nickname = null)

        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(30)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "홍길동", age = 30)

        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(30)
        assertThat(actual.nickname).isEqualTo("홍길동")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("홍길동", 30)
        val person2 = Person("홍길동", 30)

        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `copy`() {
        val person = Person("홍길동", 30)
        assertThat(person.nickname).isEqualTo("홍길동")

        val actual = person.copy(nickname = "홍")
        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(30)
        assertThat(actual.nickname).isEqualTo("홍")
    }
}
