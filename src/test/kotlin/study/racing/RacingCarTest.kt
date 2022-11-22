package study.racing

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.racing.domain.entity.RacingCar
import study.racing.domain.repository.RacingCarRepositoryImpl

class RacingCarTest {

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `Power값이 4 이상일 경우 전진한다`(power: Int) {
        val repo = RacingCarRepositoryImpl(FakePowerSource(power))
        val car = RacingCar("", repo)
        val prevPosition = car.currentPosition
        car.moveForward()
        assert(car.currentPosition == prevPosition + 1)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `Power값이 4 미만일 경우 정지한다`(power: Int) {
        val repo = RacingCarRepositoryImpl(FakePowerSource(power))
        val car = RacingCar("", repo)
        val prevPosition = car.currentPosition
        car.moveForward()
        assert(car.currentPosition == prevPosition)
    }

    @Test
    fun `자동차가 전진 가능한 경우에 전진시키면 현재 위치가 1 증가한다`() {
        val repo = FakeRacingCarRepository(0, true)
        val car = RacingCar("", repo)
        val prevPosition = car.currentPosition
        car.moveForward()
        assert(car.currentPosition == prevPosition + 1)
    }

    @Test
    fun `자동차가 전진 불가능한 경우에 전진시키면 움직이지 않는다`() {
        val repo = FakeRacingCarRepository(0, true)
        val car = RacingCar("", repo)
        val prevPosition = car.currentPosition
        car.moveForward()
        assert(car.currentPosition == prevPosition)
    }
}