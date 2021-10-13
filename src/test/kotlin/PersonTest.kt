import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest() {

    @Test
    fun `person test`() {
        // Act
        val person = Person(
            name = "임한결",
            age = 27,
        )

        // Assert
        assertThat(person.name).isEqualTo("임한결")
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `named arguments`() {
        // Arrange
        val person1 = Person("임한결", 27, "tommy")
        val person2 = Person("임한결", 28, "tommy")

        // Act
        val people = listOf(
            person1,
            person2,
        )

        // Assert
        assertThat(people).hasSize(2)
        assertThat(people).contains(person1)
    }

    @Test
    fun `data classes`() {
        // Arrange
        val person1 = Person("임한결", 28, "tommy")
        val person2 = Person("임한결", 28, "tommy")

        // Act
        val result = person1 == person2

        // Assert
        assertThat(result).isTrue
    }
}
