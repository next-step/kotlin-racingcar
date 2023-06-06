import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "이정수", age = 20, nickname = "도리루")
        assertThat(actual.name).isEqualTo("이정수")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("도리루")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "이정수", age = 20, nickname = null)
        assertThat(actual.name).isEqualTo("이정수")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "이정수", age = 20)
        assertThat(actual.name).isEqualTo("이정수")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "이정수", age = 20, "Lee")
        val person2 = Person(name = "이정수", age = 20, "Lee")
        assertThat(person1).isEqualTo(person2)
    }
}
