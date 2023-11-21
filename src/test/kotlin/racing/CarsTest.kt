package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racing.domain.Car
import racing.domain.CarName
import racing.domain.Cars

class CarsTest {
    private lateinit var cars: MutableList<Car>

    @BeforeEach
    fun `레이싱 참가할 자동차 준비`() {
        val x3 = Car(
            CarName("x3"), 5
        )
        val x5 = Car(
            CarName("x5"), 3
        )
        val cls = Car(
            CarName("cls"), 3
        )
        cars = mutableListOf<Car>(x3, x5, cls)
    }

    @Test
    fun `제일 많이 이동한 자동차가 우승자이다`() {
        val winnerCars = Cars(cars).winner
        Assertions.assertThat(winnerCars[0].name.name).isEqualTo("x3")
    }

    @Test
    fun `한명 이상이 우승자가 될수 있다`() {
        val bmw = Car(
            CarName("bmw"), 5
        )
        cars.add(bmw)
        val winnerCars = Cars(cars).winner

        Assertions.assertThat(winnerCars[0].getName()).isEqualTo("x3")
        Assertions.assertThat(winnerCars[1].getName()).isEqualTo("bmw")
    }
}
