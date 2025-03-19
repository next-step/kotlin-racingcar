import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `test named arguments`() {
        val people = listOf(
            Person("Aparna Pattathil", 27, "Aparna"),
            Person("Aparna Pattathil", 27, nickName = "Aparna"),
            Person(name = "Aparna Pattathil", nickName = "Aparna", age = 27)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("Aparna Pattathil")
            assertThat(it.age).isEqualTo(27)
            assertThat(it.nickName).isEqualTo("Aparna")
        }
    }

    @Test
    fun `test nullable types`() {
        val person = Person("Aparna Pattathil", null, "Aparna")
        assertThat(person.age).isNull()
    }

    @Test
    fun `test default arguments`() {
        val person = Person("Aparna Pattathil", null)
        assertThat(person.nickName).isBlank()
    }

    @Test
    fun `test data classes `() {
        val person1 = Person("Aparna Pattathil", null, "Aparna")
        val person2 = Person("Aparna Pattathil", null, "Aparna")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `test copying data classes `() {
        val person1 = Person("Aparna Pattathil", null, "Aparna")
        val person2 = person1.copy(age = 28)
        assertThat(person1.age).isNull()
        assertThat(person2.age).isEqualTo(28)
        assertThat(person1.name).isEqualTo(person2.name)
    }
}