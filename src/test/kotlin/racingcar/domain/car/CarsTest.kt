package racingcar.domain.car

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly

internal class CarsTest : StringSpec({

    "이동거리가 가장 긴 자동차들의 이름을 반환한다." {
        // given
        val car1 = CarFixture.getCar(name = "1번차")
        val car2 = CarFixture.getCar(name = "2번차")
        val car3 = CarFixture.getCar(name = "3번차")

        car1.fillGasAndForward(gas = Car.ENOUGH_TO_FORWARD)
        car2.fillGasAndForward(gas = Car.ENOUGH_TO_FORWARD)

        val cars = Cars(listOf(car1, car2, car3))

        // when
        val winnerNames = cars.getWinnerNames()

        // then
        winnerNames shouldContainExactly listOf(car1.getName(), car2.getName())
    }
})
