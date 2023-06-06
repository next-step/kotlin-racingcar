package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "이동준", age = 34, nickname = "dongjoon1251")
        assertThat(actual.name).isEqualTo("이동준")
        assertThat(actual.age).isEqualTo(34)
        assertThat(actual.nickname).isEqualTo("dongjoon1251")
    }

    @Test
    fun `널 타입`() {
        val actual = Person("이동준", age = 34, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "이동준", age = 34)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "이동준", age = 34, nickname = "dongjoon1251")
        val person2 = Person(name = "이동준", age = 34, nickname = "dongjoon1251")
        assertThat(person1).isEqualTo(person2)
    }
}
