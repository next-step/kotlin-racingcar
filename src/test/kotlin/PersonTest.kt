import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun nickname_null() {
        val person = Person("박주한", 18, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun has_nickname() {
        val person = Person("박주한", 18, "박츄")
        assertThat(person.nickname).isEqualTo("박츄")
    }

    @Test
    fun change_nickname() {
        val person = Person("박주한", 18, "박츄")
        person.nickname = "피카츄"
        assertThat(person.nickname).isEqualTo("피카츄")
    }
}
