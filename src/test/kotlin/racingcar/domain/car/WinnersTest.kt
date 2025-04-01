package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Name

class WinnersTest {
    @Test
    fun `car1 and car2 are winners when car1 has position 1 and car2 has position 1`() {
        // given
        val car1 = Car(Name("car1"), 1)
        val car2 = Car(Name("car2"), 1)
        val cars = listOf(car1, car2)

        // when
        val actual = Winners.of(cars)

        // then
        assertThat(actual.cars).hasSameElementsAs(cars)
    }

    @Test
    fun `car1 is winner when car1 has position 1 and car2 has position 0`() {
        // given
        val car1 = Car(Name("car1"), 1)
        val car2 = Car(Name("car2"), 0)
        val expected = listOf(car1)
        val cars = listOf(car1, car2)

        // when
        val actual = Winners.of(cars)

        // then
        assertThat(actual.cars).hasSameElementsAs(expected)
    }
}
