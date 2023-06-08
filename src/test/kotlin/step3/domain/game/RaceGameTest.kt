package step3.domain.game

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import step3.domain.car.Car
import step3.domain.car.CarFactory
import step3.domain.generator.MustFourNumberGenerator
import step3.domain.generator.MustZeroNumberGenerator
import step3.model.RaceGameErrorCode
import java.util.concurrent.atomic.AtomicInteger

class RaceGameTest : DescribeSpec({

    describe(name = "레이스 게임 시작할 때") {
        val cars = emptyList<Car>()
        val round = AtomicInteger(5)

        context(name = "자동차 개수가 지정된 개수보다 낮으면") {
            val exception = shouldThrow<IllegalArgumentException> {
                RaceGame(cars = cars, round = round)
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
            val raceGame = RaceGame(cars = cars, round = round)

            val exception = shouldThrow<IllegalStateException> {
                raceGame.basicFormulaRace()
            }

            it(name = "게임을 시작하면 남은 라운드 수가 없다는 에러가 발생한다.") {
                exception shouldHaveMessage RaceGameErrorCode.NOT_REMAINING_ROUND.message("${round.get()}")
            }

            val progress = raceGame.isProgress()

            it(name = "진행 여부를 호출하면 진행 중이지 않음을 반환한다.") {
                progress shouldBe false
            }
        }

        round.addAndGet(10)

        context(name = "라운드가 남아있는 상태에서") {
            val raceGame = RaceGame(cars = cars, round = round)

            val currentPosition = raceGame.basicFormulaRace()

            it(name = "게임을 시작하면 자동차 숫자만큼 현재 위치를 반환한다.") {
                currentPosition.size shouldBe cars.size
            }

            val progress = raceGame.isProgress()

            it(name = "진행 여부를 호출하면 진행 중임을 반환한다.") {
                progress shouldBe true
            }
        }
    }

    describe(name = "기본 룰로 게임을 시작할 때") {
        val position = AtomicInteger()
        val cars = CarFactory.createCars(count = 1, position = position.get())
        val round = AtomicInteger(10)

        context(name = "4미만일 때") {
            val raceGame = RaceGame(
                cars = cars,
                round = round,
                numberGenerator = MustZeroNumberGenerator,
            )

            it(name = "움직이지 않는다.") {
                raceGame.basicFormulaRace().firstOrNull() shouldBe position.get()
            }
        }

        context(name = "4이상일 때") {
            val raceGame = RaceGame(
                cars = cars,
                round = round,
                numberGenerator = MustFourNumberGenerator,
            )

            it(name = "한 칸 앞으로 간다.") {
                raceGame.basicFormulaRace().firstOrNull() shouldBe position.incrementAndGet()
            }
        }
    }
})
