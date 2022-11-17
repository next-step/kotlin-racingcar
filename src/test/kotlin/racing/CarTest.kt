package racing

import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.domain.CarFactory
import racing.domain.Cars

class CarTest {

    @Test
    fun `자동차 생성`() {
        val cars: Cars = CarFactory.create(3)
        AssertionsForInterfaceTypes.assertThat(cars.count()).isEqualTo(3)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 9])
    fun `자동차 이동`(num: Int) {
        val cars: Cars = CarFactory.create(3)
        for (car in cars.list()) {
            car.move(num)
            AssertionsForInterfaceTypes.assertThat(car.position).isEqualTo(1)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 3])
    fun `자동차 이동실패`(num: Int) {
        val cars: Cars = CarFactory.create(3)
        for (car in cars.list()) {
            car.move(num)
            AssertionsForInterfaceTypes.assertThat(car.position).isEqualTo(0)
        }
    }
}
