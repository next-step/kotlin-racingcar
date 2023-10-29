package racingcar.ui

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Cars
import racingcar.helper.CarFixture

class RaceResultStorageTest : BehaviorSpec({

    Given("자동차가 주어졌을 때") {
        val raceResultStorage = RaceResultStorage()
        val cars = Cars(
            cars = CarFixture.makeCars(3).onEach { it.move(5) },
            numberGenerator = CarFixture.makeFakeCarPowerGenerator(5)
        )

        When("결과를 저장하면") {
            raceResultStorage.save(cars)

            Then("자동차들의 위치 정보를 저장한다.") {
                raceResultStorage.results shouldBe listOf(
                    CarMove(2),
                    CarMove(2),
                    CarMove(2),
                )
            }
        }
    }
})
