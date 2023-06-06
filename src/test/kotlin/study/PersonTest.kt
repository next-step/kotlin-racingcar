package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "최진영", age = 20, nickname = "jinyoung")

        assertThat(actual.name).isEqualTo("최진영")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("jinyoung")
    }

    @Test
    fun `널 타입`() {
        val actual = Person("최진영", 20, null)

        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "최진영", age = 20)

        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("최진영", 20, "jinyoung")
        val person2 = Person("최진영", 20, "jinyoung")

        assertThat(person1).isEqualTo(person2)
    }
}
