package study

import Person
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    internal fun `이름 붙인 인자`() {
        val actual = Person(name = "정석준", age = 32, nickname = "디노")
        assertThat(actual.name).isEqualTo("정석준")
        assertThat(actual.age).isEqualTo(32)
        assertThat(actual.nickname).isEqualTo("디노")
    }

    @Test
    internal fun `널 타입`() {
        val actual = Person(name = "정석준", age = 32, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    internal fun `기본 인자`() {
        val actual = Person(name = "정석준", age = 32)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    internal fun `데이터 클래스`() {
        val person1 = Person(name = "정석준", age = 32, nickname = "디노")
        val person2 = Person(name = "정석준", age = 32, nickname = "디노")
        assertThat(person1).isEqualTo(person2)
    }
}
