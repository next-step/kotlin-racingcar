package racing

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.assertj.core.util.Arrays
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.domain.CarFactory
import racing.domain.Cars

class CarTest {

    @Test
    fun `자동차를 생성할 때 자동차의 이름은 5글자 이하이다`() {
        val names = Arrays.array("lee", "kkoks", "amery")
        val cars: Cars = CarFactory.create(names)
        assertThat(cars.count()).isEqualTo(3)
    }

    @Test
    fun `자동차를 생성할 때 자동차의 이름은 5글자를 초과한다`() {
        val names = Arrays.array("lee", "kkokss", "amery")
        assertThrows<IllegalArgumentException> {
            CarFactory.create(names)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 9])
    fun `자동차 이동`(num: Int) {
        val names = Arrays.array("lee", "kkoks", "amery")
        val cars: Cars = CarFactory.create(names)
        for (car in cars) {
            car.move(num)
            assertThat(car.position).isEqualTo(1)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 3])
    fun `자동차 이동실패`(num: Int) {
        val names = Arrays.array("lee", "kkoks", "amery")
        val cars: Cars = CarFactory.create(names)
        for (car in cars) {
            car.move(num)
            assertThat(car.position).isEqualTo(0)
        }
    }
}
