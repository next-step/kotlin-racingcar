package racingCar.ui

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingCar.domain.Car
import racingCar.domain.CarName
import racingCar.domain.CarPosition
import racingCar.domain.Cars
import racingCar.helper.CarFixture

class RaceResultStorageTest : BehaviorSpec({

    Given("자동차가 주어졌을 때") {
        val raceResultStorage = RaceResultStorage()
        val cars = Cars(
            cars = CarFixture.makeCars(3).onEach { it.move(5) },
            numberGenerator = CarFixture.makeFakeCarPowerGenerator(5)
        )

        When("결과를 저장하면") {
            raceResultStorage.save(cars)

            Then("경주 결과를 라운드별로 저장한다.") {
                raceResultStorage.getRoundResults() shouldBe listOf(
                    RoundResult(
                        1,
                        listOf(
                            CarMoveResult("테스트0", 2),
                            CarMoveResult("테스트1", 2),
                            CarMoveResult("테스트2", 2),
                        )
                    )
                )
            }
        }
    }

    Given("경주가 종료되었을 때") {
        val raceResultStorage = RaceResultStorage()
        val cars = Cars(
            cars = listOf(
                Car(name = CarName("테스트1"), position = CarPosition(2)),
                Car(name = CarName("테스트2"), position = CarPosition(3)),
                Car(name = CarName("테스트3"), position = CarPosition(3))
            ),
            numberGenerator = CarFixture.makeFakeCarPowerGenerator(5)
        )
        raceResultStorage.save(cars)

        When("우승자를 계산하면") {
            raceResultStorage.getWinners()

            Then("우승자들의 이름과 위치를 반환한다.") {
                raceResultStorage.getWinners() shouldBe listOf(
                    CarMoveResult("테스트2", 3),
                    CarMoveResult("테스트3", 3)
                )
            }
        }
    }
})
