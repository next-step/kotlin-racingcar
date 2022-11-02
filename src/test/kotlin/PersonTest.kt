import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * @author garden.iee
 */
class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "이정원", age = 26, nickname = "garden")
        assertThat(person.name).isEqualTo("이정원")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "이정원", age = 26, nickname = null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "이정원", age = 26)
        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "이정원", age = 26, nickname = null)
        val person2 = Person(name = "이정원", age = 26, nickname = null)
        assertThat(person1).isEqualTo(person2)
    }
}
