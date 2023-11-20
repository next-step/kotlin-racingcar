package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racing.domain.Car
import racing.domain.CarName
import racing.domain.Cars

class CarsTest{
    private lateinit var cars: List<Car>

    @BeforeEach
    fun `레이싱 참가할 자동차 준비`() {
        val x3 = Car(
            CarName("x3") , 5)
        val x5 = Car(
            CarName("x5"), 3)
        val cls = Car(
            CarName("cls"), 3)
        cars = listOf<Car>(x3, x5, cls)
    }

    @Test
    fun `자동차 중 우승자 출력`() {
        val winnerCars = Cars(cars).winner
        Assertions.assertThat(winnerCars[0].name.name).isEqualTo("x3")
    }
}
