package step3

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import step3.view.ResultView

class CarRacingTest {
    @Test
    fun `initiate cars test`() {
        val cars = Race.initiate(5)
        assertThat(cars.size).isEqualTo(5)
        for (element in cars) assertThat(element.distance).isEqualTo(0)
    }

    @Test
    fun `visualize block test`() {
        assertThat(ResultView.visualize(5)).isEqualTo("-----")
    }

    @Test
    fun `random number area test`() {
        assertThat(Race.getRandomNumber()).isGreaterThan(-1)
        assertThat(Race.getRandomNumber()).isLessThan(10)
    }

    @Test
    fun `successToMove test`() {
        assertThat(Race.successToMove(2)).isEqualTo(false)
        assertThat(Race.successToMove(8)).isEqualTo(true)
    }

    @Test
    fun `makeTurnForEach test`() {
        assertThat(Race.getDistanceForEachCar(3)).isGreaterThanOrEqualTo(3)
        assertThat(Race.getDistanceForEachCar(3)).isLessThanOrEqualTo(4)
    }
}
