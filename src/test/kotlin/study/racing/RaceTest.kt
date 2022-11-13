package study.racing

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import study.racing.entity.RacingCar
import study.racing.entity.Round
import study.racing.ui.InputView

class RaceTest {

    private val randomPowerSource = RandomPowerSource()

    @Test
    fun `자동차 대수가 1보다 작은 값이 입력된 경우 에러가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            InputView
                .CarCount(FakeCountProvider("-1"))
                .getCount()
        }
        assert(exception.message == "올바르지 않은 자동차 대수 값이 입력되었습니다.")
    }

    @Test
    fun `라운드 횟수가 1보다 작은 값이 입력된 경우 에러가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            InputView
                .RoundCount(FakeCountProvider("-1"))
                .getCount()
        }
        assert(exception.message == "올바르지 않은 시도 횟수 값이 입력되었습니다.")
    }

    @Test
    fun `자동차 대수가 숫자가 아닌 값이 입력된 경우 에러가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            InputView
                .CarCount(FakeCountProvider("&"))
                .getCount()
        }
        assert(exception.message == "올바르지 않은 자동차 대수 값이 입력되었습니다.")
    }

    @Test
    fun `자동차를 전진시키면 현재 위치가 1 증가한다`() {
        val car = RacingCar(randomPowerSource)
        val prevPosition = car.currentPosition
        car.moveForward()
        assert(car.currentPosition == prevPosition + 1)
    }

    @Test
    fun `이미 종료된 라운드를 시작하면 에러가 발생한다`() {
        val round = Round(listOf(RacingCar(randomPowerSource)))
        round.race()
        val exception = assertThrows<IllegalStateException> {
            round.race()
        }
        assert(exception.message == "이 라운드는 이미 종료되었습니다.")
    }

    @Test
    fun `Power값이 4 이상일 경우 전진한다`() {
        for (i in 4..9) {
            val car = RacingCar(FakePowerSource(i))
            val prevPosition = car.currentPosition
            car.moveForward()
            assert(car.currentPosition == prevPosition + 1)
        }
    }

    @Test
    fun `Power값이 4 미만일 경우 정지한다`() {
        for (i in 0 until 4) {
            val car = RacingCar(FakePowerSource(i))
            val prevPosition = car.currentPosition
            car.moveForward()
            assert(car.currentPosition == prevPosition)
        }
    }
}