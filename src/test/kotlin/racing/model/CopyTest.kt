package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CopyTest {
    @Test
    fun `Copy Test`() {
        val cars = mutableListOf<String>()

        cars.add("car1")
        cars.add("car2")

        val carsCopy: MutableList<String>
        carsCopy = cars
        carsCopy[0] = "car3"

        assertThat(cars[0]).isEqualTo("car3")
        assertThat(carsCopy[0]).isEqualTo("car3")
    }

    @Test
    fun `Deep Copy Test`() {
        data class Name(var name: String)

        fun List<Name>.deepCopy(): List<Name> = map { it.copy() }

        val cars = mutableListOf<Name>()

        cars.add(Name("car1"))
        cars.add(Name("car2"))

        val carsCopy: List<Name>
        carsCopy = cars.deepCopy()
        carsCopy[0].name = "car3"

        assertThat(cars[0].name).isEqualTo("car1")
        assertThat(carsCopy[0].name).isEqualTo("car3")
    }
}
