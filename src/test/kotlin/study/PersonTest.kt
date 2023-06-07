package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val tPerson = Person(name = "junjun", age = 3, nickname = "jun")
        assertThat(tPerson.name).isEqualTo("junjun")
        assertThat(tPerson.age).isEqualTo(3)
        assertThat(tPerson.nickname).isEqualTo("jun")
    }

    @Test
    fun `널 타입`() {
        val tPerson = Person("junjun", 3, null)
        assertThat(tPerson.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val tPerson = Person(name = "junjun", age = 3)
        assertThat(tPerson.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val tPerson1 = Person("junjun", 3, "jun")
        val tPerson2 = Person("junjun", 3, "jun")
        assertThat(tPerson1).isEqualTo(tPerson2)
    }
}
