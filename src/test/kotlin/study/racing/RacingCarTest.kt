package study.racing

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.racing.entity.RacingCar

class RacingCarTest {

    private lateinit var randomPowerSource: RandomPowerSource

    @BeforeEach
    fun init() {
        randomPowerSource = RandomPowerSource()
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `Power값이 4 이상일 경우 전진한다`(power: Int) {
        val car = RacingCar(FakePowerSource(power))
        val prevPosition = car.currentPosition
        car.moveForward()
        assert(car.currentPosition == prevPosition + 1)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `Power값이 4 미만일 경우 정지한다`(power: Int) {
        val car = RacingCar(FakePowerSource(power))
        val prevPosition = car.currentPosition
        car.moveForward()
        assert(car.currentPosition == prevPosition)
    }

    @Test
    fun `자동차를 전진시키면 현재 위치가 1 증가한다`() {
        val car = RacingCar(randomPowerSource)
        val prevPosition = car.currentPosition
        car.moveForward()
        assert(car.currentPosition == prevPosition + 1)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `Power값이 4 이상일 경우에 전진이 가능하다`() {
        val car = RacingCar(FakePowerSource(4))
        val prevPosition = car.currentPosition
        car.moveForward()
        assert(car.currentPosition == prevPosition + 1)
    }
}