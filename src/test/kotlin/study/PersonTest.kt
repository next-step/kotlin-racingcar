package study

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "홍길동", age = 20, nickname = "홍")
        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("홍")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "홍길동", age = 20, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "홍길동", age = 20)
        assertThat(actual.nickname).isEqualTo(actual.name)
    }

    @Test
    fun `데이터 클래스`() {
        val persion1 = Person(name = "홍길동", age = 20)
        val persion2 = Person(name = "홍길동", age = 20)
        assertThat(persion1).isEqualTo(persion2)
    }
}
