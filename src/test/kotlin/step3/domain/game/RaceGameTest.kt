package step3.domain.game

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import step3.domain.car.Car
import step3.domain.car.CarFactory
import step3.domain.formula.BasicRuleMoveFormula
import step3.domain.formula.NotMoveFormula
import step3.domain.generator.MockNumberGenerator
import step3.model.RaceGameErrorCode
import java.util.concurrent.atomic.AtomicInteger

class RaceGameTest : DescribeSpec({

    describe(name = "레이스 게임 시작할 때") {
        val cars = emptyList<Car>()
        val round = AtomicInteger(5)

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
        val cars = CarFactory.createCars(count = 3)
        val round = AtomicInteger()

        context(name = "라운드가 모두 소진되었으면") {
            val raceGame = RaceGame(cars = cars, round = round, moveFormula = NotMoveFormula)

            val exception = shouldThrow<IllegalStateException> {
                raceGame.race { }
            }

            it(name = "게임을 시작하면 남은 라운드 수가 없다는 에러가 발생한다.") {
                exception shouldHaveMessage RaceGameErrorCode.NOT_REMAINING_ROUND.message("${round.get()}")
            }
        }

        round.incrementAndGet()

        context(name = "라운드가 남아있는 상태에서") {
            val raceGame = RaceGame(cars = cars, round = round, moveFormula = NotMoveFormula)
            val expect = mutableListOf<Int>()

            raceGame.race { raceResult -> expect.addAll(elements = raceResult) }

            it(name = "게임을 시작하면 자동차 숫자만큼 현재 위치를 반환한다.") {
                expect.size shouldBe cars.size
            }
        }
    }

    describe(name = "기본 룰로 게임을 시작할 때") {
        val position = AtomicInteger()
        val cars = CarFactory.createCars(count = 1, position = position.get())

        context(name = "4미만일 때") {
            val round = AtomicInteger(1)

            val raceGame = RaceGame(
                cars = cars,
                round = round,
                moveFormula = BasicRuleMoveFormula(
                    numberGenerator = MockNumberGenerator(value = 0),
                ),
            )

            val expect = mutableListOf<Int>()

            raceGame.race { raceResult -> expect.addAll(elements = raceResult) }

            it(name = "움직이지 않는다.") {
                expect.firstOrNull() shouldBe position.get()
            }
        }

        context(name = "4이상일 때") {
            val round = AtomicInteger(1)

            val raceGame = RaceGame(
                cars = cars,
                round = round,
                moveFormula = BasicRuleMoveFormula(
                    numberGenerator = MockNumberGenerator(value = 4),
                ),
            )

            val expect = mutableListOf<Int>()

            raceGame.race { raceResult -> expect.addAll(elements = raceResult) }

            it(name = "한 칸 앞으로 간다.") {
                expect.firstOrNull() shouldBe position.incrementAndGet()
            }
        }
    }
})
