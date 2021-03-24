package car.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarNamesTests {
    @Test
    fun `CarNames 만들때는 String array를 받을 수 있다`() {
        val nameArray = "오,오길,오길환,오길환이,오길환이다".split(",").toTypedArray()

        val carNames = CarNames(nameArray)

        assertThat(carNames)
            .containsExactlyInAnyOrderElementsOf(nameArray.map(::CarName))
    }

    @Test
    fun `CarNames 만들때는 CarName List를 받을 수 있다`() {
        val names = listOf(
            CarName("오"),
            CarName("길"),
            CarName("환")
        )

        val carNames = CarNames(names)

        assertThat(carNames)
            .containsExactlyInAnyOrderElementsOf(names)
    }
}
