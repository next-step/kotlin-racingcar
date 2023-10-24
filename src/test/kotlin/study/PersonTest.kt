package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 불인 인자`() {
        val actual = Person(name = "홍길동", age = 20, nickname = "홍홍홍")

        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("홍홍홍")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "홍길동", age = 20, nickname = null)

        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "홍길동", age = 20)

        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("홍길동")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "홍길동", age = 20)
        val person2 = Person(name = "홍길동", age = 20)

        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `copy`() {
        val person = Person(name = "홍길동", age = 20)
        val actual = person.copy(nickname = "홍홍홍")

        assertThat(actual.nickname).isEqualTo("홍홍홍")
    }
}
