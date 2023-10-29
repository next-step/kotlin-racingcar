package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "김선달", age = 30, nickname = "선달이")
        assertThat(actual.name).isEqualTo("김선달")
        assertThat(actual.age).isEqualTo(30)
        assertThat(actual.nickname).isEqualTo("선달이")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "김선달", age = 30, nickname = null)
        assertThat(actual.name).isEqualTo("김선달")
        assertThat(actual.age).isEqualTo(30)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "김선달", age = 30)
        assertThat(actual.name).isEqualTo("김선달")
        assertThat(actual.age).isEqualTo(30)
        assertThat(actual.nickname).isEqualTo("김선달")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "김선달", age = 30)
        val person2 = Person(name = "김선달", age = 30)

        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `Copy`() {
        val person = Person(name = "김선달", age = 30)
        assertThat(person.name).isEqualTo("김선달")

        val actual = person.copy(nickname = "선")
        assertThat(actual.name).isEqualTo("김선달")
        assertThat(actual.age).isEqualTo(30)
        assertThat(actual.nickname).isEqualTo("선")
    }
}
