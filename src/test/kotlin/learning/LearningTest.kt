package learning

import learning.domain.Animal
import learning.domain.Person
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.util.function.Consumer


internal class LearningTest {
    @Test
    internal fun `named arguments`() {
        val people: List<Person> = listOf(
            Person("안운장", 28, "호돌"),
            Person(name = "안운장", age = 28, nickname = "호돌"),
            Person("안운장", nickname = "호돌", age = 28),
        )
        assertThat(people).allSatisfy(Consumer {
            assertThat(it.name).isEqualTo("안운장")
            assertThat(it.age).isEqualTo(28)
            assertThat(it.nickname).isEqualTo("호돌")
        })
    }

    @Test
    internal fun `nullable types`() {
        val person = Person("안운장", 28, null)
        assertAll(
            { assertThat(person.name).isEqualTo("안운장") },
            { assertThat(person.age).isEqualTo(28) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    internal fun `default arguments`() {
        val person = Person("안운장", 28)
        assertAll(
            { assertThat(person.name).isEqualTo("안운장") },
            { assertThat(person.age).isEqualTo(28) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    internal fun `data classes`() {
        val animal1 = Animal("멍뭉이", 2)
        val animal2 = Animal("멍뭉이", 2)
        val person1 = Person("안운장", 28, "호돌")
        val person2 = Person("안운장", 28, "호돌")
        val person3 = Person("안운장", 29, "호돌")
        assertAll(
            { assertThat(animal1).isNotEqualTo(animal2) },
            { assertThat(person1).isEqualTo(person2) },
            { assertThat(person1).isNotEqualTo(person3)}
        )
    }
}
