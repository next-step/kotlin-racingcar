package racingCar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingCar.helper.CarFixture

class RaceResultTest : BehaviorSpec({

    val raceResult = RaceResult()
    val cars = Cars(
        cars = CarFixture.makeCars(2).onEach { it.move(5) },
        numberGenerator = CarFixture.makeFakeCarPowerGenerator(5)
    )

    Given("자동차가 주어졌을 때") {

        When("결과를 저장하면") {
            raceResult.save(cars)

            Then("경주 결과를 라운드별로 저장한다.") {
                raceResult.getRoundResults() shouldBe listOf(
                    RaceResult.RoundResult(
                        1,
                        listOf(
                            RaceResult.CarMoveResult("테스트0", 2),
                            RaceResult.CarMoveResult("테스트1", 2),
                        )
                    )
                )
            }
        }
    }

    Given("경주 결과가 주어졌을 때") {
        raceResult.save(cars)
        raceResult.save(cars)

        When("라운드 전체 결과를 조회하면") {
            val results = raceResult.getRoundResults()

            Then("먼저 실행된 라운드 순으로 정렬하여 반환한다.") {
                results shouldBe listOf(
                    RaceResult.RoundResult(
                        1,
                        listOf(
                            RaceResult.CarMoveResult("테스트0", 2),
                            RaceResult.CarMoveResult("테스트1", 2),
                        )
                    ),
                    RaceResult.RoundResult(
                        2,
                        listOf(
                            RaceResult.CarMoveResult("테스트0", 2),
                            RaceResult.CarMoveResult("테스트1", 2),
                        )
                    ),
                )
            }
        }
    }
})
