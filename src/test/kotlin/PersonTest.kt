package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    internal fun `이름 붙인 인자`() {
        val actual = Person(name = "오한결", nickname = "kimbacksul", age = 20)
        assertThat(actual.name).isEqualTo("오한결")
        assertThat(actual.nickname).isEqualTo("kimbacksul")
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
        val Person1 = Person("홍길동", 20, "홍")
        val Person2 = Person("홍길동", 20, "홍")
        assertThat(Person1).isEqualTo(Person2)
    }
}
