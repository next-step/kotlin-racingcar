package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.domain.RacingCarsFactoryImpl
import racing.model.CarCount


internal class RacingCarGarageTest {

    lateinit var racingCarGarage: RacingCarGarage

    @BeforeEach
    fun setUp() {
        racingCarGarage = RacingCarGarage(
            racingCarsFactory = RacingCarsFactoryImpl()
        )
    }

    /**
     * FYI, inline class 아직 ParameterizedTest 미지원
     * https://github.com/junit-team/junit5/issues/2703
     */
    @ParameterizedTest
    @ValueSource(ints = [3, 10, 2])
    fun `필요한 차량 수 만큼 자동차를 생성한다`(carCount: Int) {
        val cars = racingCarGarage.createCars(CarCount(carCount))
        assertThat(cars.size).isEqualTo(carCount)
    }

    @Test
    fun `현재 차고에 차량이 있는지 확인했을 때 차가 있는 경우`() {
        racingCarGarage.createCars(CarCount(5))
        assertThat(racingCarGarage.shouldCreateCars()).isFalse
    }

    @Test
    fun `현재 차고에 차량이 있는지 확인했을 때 차가 없는 경우`() {
        assertThat(racingCarGarage.shouldCreateCars()).isTrue
    }

    @Test
    fun `1 lap 돈 차량을 차고에 주차(저장)한다`() {
        val cars = racingCarGarage.createCars(CarCount(5))
        val testCars = cars.mapIndexed { index, car ->
            if (index % 2 == 0) car.copy(car.mileage + 1) else car.copy()
        }
        racingCarGarage.parkCars(testCars)
        assertThat(racingCarGarage.cars).isEqualTo(testCars)
    }
}
