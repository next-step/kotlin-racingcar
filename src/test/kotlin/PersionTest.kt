import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersionTest {
    @Test
    fun `이름 붙인 인자`() {
        val people =
            listOf(
                Person("박민규", 28, "Charming"),
                Person("박민규", 28, nickname = "Charming"),
                Person(name = "박민규", nickname = "Charming", age = 28)
            )

        assertThat(people[0].name).isEqualTo("박민규")
        assertThat(people[1].name).isEqualTo("박민규")
        assertThat(people[2].name).isEqualTo("박민규")
    }

    @Test
    fun `널 타입`() {
        val person = Person("박민규", 28, "Charming")

        assertThat(person.name).isEqualTo("박민규")
        assertThat(person.age).isEqualTo(28)
        assertThat(person.nickname).isEqualTo("Charming")
    }

    @Test
    fun `기본 인자`() {
        val person = Person("박민규", 28)

        assertThat(person.name).isEqualTo("박민규")
        assertThat(person.age).isEqualTo(28)
        assertThat(person.nickname).isEqualTo("Charming")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("박민규", 28, "Charming")
        val person2 = Person("박민규", 28, "Charming")

        assertThat(person1).isEqualTo(person2)
    }
}
