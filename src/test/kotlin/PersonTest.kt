import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "김다보미", nickname = "마모미", age = 30)

        assertThat(actual.name).isEqualTo("김다보미")
        assertThat(actual.nickname).isEqualTo("마모미")
        assertThat(actual.age).isEqualTo(30)
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "김다보미", age = 30, nickname = null)

        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "김다보미", age = 30)

        assertThat(actual.nickname).isEqualTo("김다보미")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "김다보미", age = 30)
        val person2 = Person(name = "김다보미", age = 30)

        assertThat(person1).isEqualTo(person2)
    }
}
