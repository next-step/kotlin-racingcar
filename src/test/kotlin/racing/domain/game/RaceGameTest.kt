package racing.domain.game

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import racing.domain.car.Car
import racing.domain.car.CarFactory
import racing.domain.formula.BasicRuleMoveFormula
import racing.domain.formula.NotMoveFormula
import racing.domain.generator.MockNumberGenerator
import racing.model.RaceGameErrorCode

class RaceGameTest : DescribeSpec({

    describe(name = "레이스 게임 시작할 때") {
        val cars = emptyList<Car>()
        val round = 5

        context(name = "자동차 개수가 지정된 개수보다 낮으면") {
            val exception = shouldThrow<IllegalArgumentException> {
                RaceGame(cars = cars, round = round, moveFormula = NotMoveFormula)
            }

            it(name = "시작할 수 없다는 에러가 발생한다.") {
                exception shouldHaveMessage RaceGameErrorCode.INVALID_CAR_COUNT.message("1 ${cars.size}")
            }
        }
    }

    describe(name = "레이스 게임 시작한 후") {
        val cars = CarFactory.createCars(
            carNames = listOf("test1", "test2", "test3")
        )

        val round = 0

        context(name = "라운드가 모두 소진되었으면") {
            val raceGame = RaceGame(cars = cars, round = round, moveFormula = NotMoveFormula)

            val exception = shouldThrow<IllegalStateException> {
                raceGame.race { }
            }

            it(name = "게임을 시작하면 남은 라운드 수가 없다는 에러가 발생한다.") {
                exception shouldHaveMessage RaceGameErrorCode.NOT_REMAINING_ROUND.message(round.toString())
            }
        }

        context(name = "라운드가 남아있는 상태에서") {
            val raceGame = RaceGame(cars = cars, round = 1, moveFormula = NotMoveFormula)
            val expect = mutableListOf<RaceGameResult>()

            raceGame.race { raceResult -> expect.addAll(elements = raceResult) }

            it(name = "게임을 시작하면 자동차 숫자만큼 현재 위치를 반환한다.") {
                expect.size shouldBe cars.size
            }

            val currentHeadOfRace = raceGame.currentHeadOfRace()

            it(name = "시작 시에는 현재 선두가 모두를 반환한다.") {
                currentHeadOfRace.size shouldBe cars.size
            }
        }

        val headOfRaceCar = CarFactory.createCar(name = "andy", position = 3)
        val anotherCar = CarFactory.createCar(name = "andy", position = 2)
        val loserCar = CarFactory.createCar(name = "andy", position = 1)

        context(name = "하나의 차 포지션이 앞서있다면") {
            val raceGame = RaceGame(
                cars = listOf(headOfRaceCar, anotherCar, loserCar),
                round = round,
                moveFormula = NotMoveFormula,
            )

            val currentHeadOfRace = raceGame.currentHeadOfRace()

            it(name = "시작 시에는 현재 선두가 모두를 반환한다.") {
                currentHeadOfRace.size shouldBe 1
                currentHeadOfRace.firstOrNull() shouldBe headOfRaceCar.name
            }
        }
    }

    describe(name = "기본 룰로 게임을 시작할 때") {
        val position = 0
        val carNames = listOf("test1")
        val cars = CarFactory.createCars(carNames = carNames, position = position)

        context(name = "4미만일 때") {
            val round = 1

            val raceGame = RaceGame(
                cars = cars,
                round = round,
                moveFormula = BasicRuleMoveFormula(
                    numberGenerator = MockNumberGenerator(value = 0),
                ),
            )

            val expect = mutableListOf<RaceGameResult>()

            raceGame.race { raceResult -> expect.addAll(elements = raceResult) }

            it(name = "움직이지 않는다.") {
                expect.firstOrNull()?.position shouldBe position
            }
        }

        context(name = "4이상일 때") {
            val round = 1

            val raceGame = RaceGame(
                cars = cars,
                round = round,
                moveFormula = BasicRuleMoveFormula(
                    numberGenerator = MockNumberGenerator(value = 4),
                ),
            )

            val expect = mutableListOf<RaceGameResult>()

            raceGame.race { raceResult -> expect.addAll(elements = raceResult) }

            it(name = "한 칸 앞으로 간다.") {
                expect.firstOrNull()?.position shouldBe position + 1
            }
        }
    }
})
