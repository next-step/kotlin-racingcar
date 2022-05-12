package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarRacingTest {
    @Test
    fun `레이싱을 해본다`() {
        val carRacing = CarRacing()
        carRacing.moveCars(cars = listOf(Car("현대"), Car("KIA"), Car("SAMSUNG")), moveCount = 5)
    }

    @Test
    fun `차 리스트 생성하고 차 리스트에 각자 이름이 제대로 들어간다`() {
        val carRacing = CarRacing()
        val cars: List<Car> = carRacing.createCars(listOf("현대", "samsung", "L9"))
        assertThat(cars[0].name).isEqualTo("현대")
        assertThat(cars[1].name).isEqualTo("samsung")
        assertThat(cars[2].name).isEqualTo("L9")
    }
}
