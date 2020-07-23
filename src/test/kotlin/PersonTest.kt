import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {

    @Test
    fun constructor() {
        val person = Person("aa", 30, "bb")
        assertAll(
            { assertThat(person.age).isEqualTo(30) },
            { assertThat(person.name).isEqualTo("aa") },
            { assertThat(person.nickname).isEqualTo("bb") }
        )
    }
}
