package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "홍길동", nickname = "홍", age = 20)
        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("길동")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "홍길동", nickname = null, age = 20)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "홍길동", age = 20)
        assertThat(actual.nickname).isEqualTo("홍길동")
    }

    @Test
    fun `데이터 클래스`() {
        val actual1 = Person(name = "홍길동", age = 20)
        val actual2 = Person(name = "홍길동", age = 20)
        assertThat(actual1).isEqualTo(actual2)
    }
}
