package racing

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.domain.CarFactory
import racing.domain.Cars
import racing.domain.ResultStatistics

class RacingGameTest {

    @Test
    fun `자동차 생성`() {
        val cars: Cars = CarFactory.create(3)
        assertThat(cars.count()).isEqualTo(3)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 9])
    fun `자동차 이동`(num: Int) {
        val cars: Cars = CarFactory.create(3)
        for (car in cars) {
            car.move(num)
            assertThat(car.routes().size()).isEqualTo(1)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 3])
    fun `자동차 이동실패`(num: Int) {
        val cars: Cars = CarFactory.create(3)
        for (car in cars) {
            car.move(num)
            assertThat(car.routes().size()).isEqualTo(0)
        }
    }

    @Test
    fun `실행결과 출력`() {
        val cars: Cars = CarFactory.create(1)
        for (car in cars) {
            car.move(4)
        }
        assertThat(ResultStatistics(cars).toResult()).isEqualTo("-\n")
    }
}
