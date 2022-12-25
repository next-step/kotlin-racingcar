package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.strategy.CanMovableStrategyMock

class RaceTest : BehaviorSpec({
    given("레이싱 자동차 게임") {
        `when`("자동차 대수와 라운드 수가 정해지면") {
            val totalRound = 2

            val listOfCars = List(2) { Car("자동차$it", it) }
            val cars = Cars(listOfCars)

            and("경기가 시작되고") {
                val race = Race(cars, totalRound)

                then("경기 결과를 도출할 수 있다.") {
                    val raceResult = race.run(CanMovableStrategyMock())
                    raceResult.roundHistories.size shouldBe 2

                    val finalWinners = raceResult.getFinalRoundWinners()
                    finalWinners shouldBe listOf(Car("자동차1", 3))
                }
            }
        }

        `when`("자동차 대수가 1대 미만일 경우") {
            then("경기를 시작할 수 없습니다.") {
                val listOfCar = listOf<Car>()
                val cars = Cars(listOfCar)

                val totalRound = 2

                shouldThrow<IllegalArgumentException> {
                    Race(cars, totalRound)
                }
            }
        }

        `when`("라운드가 1회 미만일 경우") {
            then("경기를 시작할 수 없습니다.") {
                val listOfCars = List(2) { Car("자동차$it", it) }
                val cars = Cars(listOfCars)

                val totalRound = 0

                shouldThrow<IllegalArgumentException> {
                    Race(cars, totalRound)
                }
            }
        }
    }
})
