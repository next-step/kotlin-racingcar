package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "박세준", age = 27, nickname = "parkjun5")

        assertThat(actual.name).isEqualTo("박세준")
        assertThat(actual.age).isEqualTo(27)
        assertThat(actual.nickname).isEqualTo("parkjun5")
    }

    @Test
    fun `널 타입`() {
        val nullable = Person("테스터", 20, null)

        assertThat(nullable.name).isEqualTo("테스터")
        assertThat(nullable.age).isEqualTo(20)
        assertThat(nullable.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "박세준", age = 20)

        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "박세준", age = 20, nickname = "Park")
        val person2 = Person(name = "박세준", age = 20, nickname = "Park")

        assertThat(person1).isEqualTo(person2)
    }
}
