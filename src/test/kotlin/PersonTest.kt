import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import study.Person

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("권대원", 20, "KwonDae"),
            Person("권대원", 20, nickname = "KwonDae"),
            Person(name = "권대원", age =  20, nickname =  "KwonDae")
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("권대원")
            assertThat(it.age).isEqualTo(20)
            assertThat(it.nickname).isEqualTo("KwonDae")
        }
    }

    @Test
    fun `널타입`() {
        val person = Person("권대원", 20, null)
        assertAll(
            { assertThat(person.name).isEqualTo("권대원") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본 인자`() {
        val person = Person("권대원", 20)
        assertAll(
            { assertThat(person.name).isEqualTo("권대원") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `데이터클래스`() {
        val person1 = Person("권대원", 20, "KwonDae")
        val person2 = Person("권대원", 20, "KwonDae")
        assertThat(person1).isEqualTo(person2)
    }
}