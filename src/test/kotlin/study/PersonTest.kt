package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "홍길동", age = 32, nickname = "홍길동")
        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(32)
        assertThat(actual.nickname).isEqualTo("홍길동")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "홍길동", age = 31, nickname = null)
        val actual2 = Person(name = "홍길동", age = 31)
        assertThat(actual.nickname).isNull()
        assertThat(actual2.nickname).isNotNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person("홍길동", 30)
        assertThat(actual.nickname).isEqualTo("홍길동")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("홍길동", 20, "홍길동")
        val person2 = Person("홍길동", 20, "홍길동")
        assertThat(person1).isEqualTo(person2)
    }
}
