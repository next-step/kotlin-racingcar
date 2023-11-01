package racingcar.domain.configuration

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingcar.controller.CarRacingRequest

class CarRacingConfigurationTest : FunSpec({
    context("자동차 경주 게임 설정 정보 생성") {
        test("자동차 경주 게임 설정 정보가 생성된다") {
            val carNames = listOf("name1", "name2")
            val tryCount = 2

            val result = CarRacingConfiguration.of(CarRacingRequest(tryCount, carNames))

            result.cars.size shouldBe carNames.size
            result.cars.forEachIndexed { index, car ->
                car.name.value shouldBe carNames[index]
                car.position shouldBe 0
            }
            result.round shouldBe tryCount
        }
    }
})
