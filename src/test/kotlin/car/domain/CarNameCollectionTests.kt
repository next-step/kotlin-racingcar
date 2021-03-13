package car.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarNameCollectionTests {
    @Test
    fun `CarNameCollection 만들때는 String array를 받을 수 있다`() {
        val nameArray = "오,오길,오길환,오길환이,오길환이다".split(",").toTypedArray()

        val carNameCollection = CarNameCollection(nameArray)

        assertThat(carNameCollection.names)
            .containsExactlyInAnyOrder(
                CarName(nameArray[0]),
                CarName(nameArray[1]),
                CarName(nameArray[2]),
                CarName(nameArray[3]),
                CarName(nameArray[4])
            )
    }

    @Test
    fun `CarNameCollection 만들때는 CarName List를 받을 수 있다`() {
        val names = listOf(
            CarName("오"),
            CarName("길"),
            CarName("환")
        )

        val carNameCollection = CarNameCollection(names)

        assertThat(carNameCollection.names)
            .containsExactlyInAnyOrder(
                CarName(names[0].name),
                CarName(names[1].name),
                CarName(names[2].name)
            )
    }
}
