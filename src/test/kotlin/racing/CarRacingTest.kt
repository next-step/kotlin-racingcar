package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarRacingTest {
    @Test
    fun `레이싱을 해본다`() {
        val carRacing = CarRacing()
        carRacing.moveCars(cars = listOf(Car(), Car(), Car()), moveCount = 5)
    }

    @Test
    fun `차 리스트 생성`() {
        val carRacing = CarRacing()
        val cars = carRacing.createCars(5)
        assertThat(cars.size).isEqualTo(5)
    }
}
