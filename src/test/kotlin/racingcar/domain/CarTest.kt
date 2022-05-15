package racingcar.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Car.Companion.ENOUGH_TO_FORWARD
import racingcar.domain.Car.Companion.FORWARD_DISTANCE

internal class CarTest : FreeSpec({

    "자동차는 $ENOUGH_TO_FORWARD 이상의 가스가 채워지면 전진한다." - {
        listOf(
            ENOUGH_TO_FORWARD,
            ENOUGH_TO_FORWARD + 1,
            ENOUGH_TO_FORWARD + 100,
        ).forEach { gas ->
            "$gas 만큼 가스를 채우면 전진한다." {
                // given
                val car = Car()
                val distanceBeforeFillingGas = car.distance

                // when
                car.fillGasAndForward(gas)

                // then
                car.distance shouldBe distanceBeforeFillingGas + FORWARD_DISTANCE
            }
        }
    }

    "자동차는 $ENOUGH_TO_FORWARD 미만의 가스가 채워지면 전진하지 못한다." - {
        listOf(
            ENOUGH_TO_FORWARD - 1,
            ENOUGH_TO_FORWARD - 3,
        ).forEach { gas ->
            "$gas 만큼 가스를 채우면 전진하지 못한다." {
                // given
                val car = Car()
                val distanceBeforeFillingGas = car.distance

                // when
                car.fillGasAndForward(gas)

                // then
                car.distance shouldBe distanceBeforeFillingGas
            }
        }
    }
})
