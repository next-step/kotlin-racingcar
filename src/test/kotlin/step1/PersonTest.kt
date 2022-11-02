package step1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "조규현", age = 30, nickname = "리규")
        assertThat(person.name).isEqualTo("조규현")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("리규")
    }

    @Test
    internal fun `널 타입`() {
        val person = Person("조규현", 30, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    internal fun `기본 인자`() {
        val person = Person("조규현", 30)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("조규현", 30)
        val person2 = Person("조규현", 30)
        assertThat(person1).isEqualTo(person2)
    }
}
