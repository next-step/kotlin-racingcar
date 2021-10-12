package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙은 인자`() {
        val person1 = Person(name = "김우재", age = 26, nickname = "우지")
        val person2 = Person(nickname = "우지", age = 26, name = "김우재")

        assertAll(
            { assertThat(person1.name).isEqualTo(person2.name) },
            { assertThat(person1.age).isEqualTo(person2.age) },
            { assertThat(person1.nickname).isEqualTo(person2.nickname) }
        )
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "김우재", age = 26, nickname = null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "김우재", age = 26)
        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "김우재", age = 26, nickname = "우지")
        val person2 = Person(name = "김우재", age = 26, nickname = "우지")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person1 = Person(name = "김우재", age = 26, nickname = "우지")
        val person2 = person1.copy(nickname = null)
        assertThat(person1.nickname).isEqualTo("우지")
        assertThat(person2.nickname).isNull()
    }
}
