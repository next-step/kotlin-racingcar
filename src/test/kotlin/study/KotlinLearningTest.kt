package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class KotlinLearningTest {
    @Test
    fun `named arguments`() {
        val people =
            listOf(
                Person("김설영", 100, "딱구"),
                Person("김설영", 100, nickname = "딱구"),
                Person(nickname = "딱구", name = "김설영", age = 100),
            )

        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("김설영")
            assertThat(it.age).isEqualTo(100)
            assertThat(it.nickname).isEqualTo("딱구")
        }
    }

    @Test
    fun `nullable type`() {
        val person = Person("김설영", null, null)

        assertAll(
            { assertThat(person.name).isEqualTo("김설영") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() },
        )
    }

    @Test
    fun `default arguments`() {
        val person = Person("김설영")

        assertAll(
            { assertThat(person.name).isEqualTo("김설영") },
            { assertThat(person.age).isEqualTo(0) },
            { assertThat(person.nickname).isEmpty() },
        )
    }

    @Test
    fun `data classes`() {
        val dataPerson1 = DataPerson("김설영", 100, "딱구")
        val dataPerson2 = DataPerson("김설영", 100, "딱구")
        val dataPerson3 = DataPerson("김설영", 10000, "딱구")

        assertAll(
            { assertThat(dataPerson1).isEqualTo(dataPerson2) },
            { assertThat(dataPerson1).isNotEqualTo(dataPerson3) },
        )
    }

    @Test
    fun `String join`() {
        val operators = setOf("+", "-", "*", "/")

        val joinToString = operators.joinToString(prefix = "\\", separator = "\\")

        assertThat(joinToString).isEqualTo("\\+\\-\\*\\/")
    }

    @Test
    fun `until and step`() {
        val strings = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")

        val result1 = mutableListOf<Int>()
        for (i in 1 until strings.size step 2) {
            result1.add(i)
        }

        val result2 = (1 until strings.size step 2).toList()

        assertThat(result1).isEqualTo(listOf(1, 3, 5, 7))
        assertThat(result2).isEqualTo(listOf(1, 3, 5, 7))
    }

    @Test
    fun `maxOf and maxWith and maxBy`() {
        val maxAge = 40
        val maxAgePerson = Person("", maxAge)
        val people =
            listOf(
                Person("", 10),
                Person("", 20),
                Person("", 30),
                maxAgePerson,
            )

        val maxBy = people.maxBy { person -> person.age!! }
        assertThat(maxBy).isSameAs(maxAgePerson)

        val maxOf = people.maxOf { person -> person.age!! }
        assertThat(maxOf).isEqualTo(maxAge)

        val maxWith = people.maxWith(compareBy { person -> person.age!! })
        assertThat(maxWith).isSameAs(maxAgePerson)
    }
}
