package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "민성", age = 20, nickname = "minsung1023")
        assertThat(actual.name).isEqualTo("민성")
        assertThat(actual.nickname).isEqualTo("minsung1023")
        assertThat(actual.age).isEqualTo(20)
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "민성", age = 20, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "민성", age = 20)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("민성", 20, nickname = "Hong")
        val person2 = Person("민성", 20, nickname = "Hong")

        assertThat(person1).isEqualTo(person2)
    }
}
