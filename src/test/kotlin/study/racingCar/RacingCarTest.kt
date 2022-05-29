package study.racingCar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import study.racingCar.domain.Car
import study.racingCar.domain.RacingCarLogic
import study.racingCar.domain.WinnersLogic

class RacingCarTest {

    @Test
    fun `무작위 수가 4이상일 경우에만 전진한다`() {
        val car = Car("pobi")
        val initialMovedSteps = car.mileage

        car.tryMove(4).mileage
        assertThat(car.mileage).isEqualTo(initialMovedSteps + 1)
    }

    @Test
    fun `무작위 수가 4미만인 경우에는 전진하지 않는다`() {
        val car = Car("pobi")
        val initialMovedSteps = car.mileage

        car.tryMove(1).mileage
        assertThat(car.mileage).isEqualTo(initialMovedSteps)
    }

    @Test
    fun `자동차 이름이 5글자 이하만 허용된다`() {
        val car = Car("55555")
        assertThat(car.carName).isEqualTo("55555")
    }

    @Test
    fun `자동차 이름이 5글자를 초과할 수 없다`() {
        assertThatThrownBy {
            val car = Car("666666")
        }.isInstanceOf(java.lang.IllegalArgumentException::class.java)
    }

    @Test
    fun `우승자는 한명이상일 수 있다`() {
        val carNames = listOf("test1", "test2", "test3")
        val tryNum = 5
        val mileageRecords = RacingCarLogic().startRacing(carNames, tryNum)
        val winners = WinnersLogic().judgeWinners(mileageRecords).split(",")
        assertThat(winners.size).isGreaterThanOrEqualTo(1)
    }
}
