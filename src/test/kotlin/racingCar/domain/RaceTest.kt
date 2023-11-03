package racingCar.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingCar.helper.CarFixture

class RaceTest : DescribeSpec({

    val car1 = CarFixture.makeCar("테스트1", 1)
    val car2 = CarFixture.makeCar("테스트2", 2)

    val race = Race(
        tryCount = TryCount(2),
        cars = Cars(
            cars = listOf(car1, car2),
            numberGenerator = CarFixture.makeFakeCarPowerGenerator(5)
        ),
    )

    describe("start") {

        context("경주를 시작하면") {
            race.start()

            it("주어진 시도 횟수만큼 차들이 경주를 시작한다.") {
                car1.position shouldBe CarPosition(3)
                car2.position shouldBe CarPosition(4)
            }
        }
    }

    describe("getRoundResults") {

        context("경주가 종료되지 않았으면") {
            it("예외가 발생한다.") {
                shouldThrowWithMessage<IllegalStateException>("아직 경기가 종료되지 않았습니다.") {
                    race.getRoundResults()
                }
            }
        }

        context("경주가 종료되었으면") {
            race.start()

            it("라운드별 결과를 반환한다.") {
                race.getRoundResults() shouldBe listOf(
                    RaceResult.RoundResult(
                        1,
                        listOf(
                            RaceResult.CarMoveResult("테스트1", 2),
                            RaceResult.CarMoveResult("테스트2", 3)
                        )
                    ),
                    RaceResult.RoundResult(
                        2,
                        listOf(
                            RaceResult.CarMoveResult("테스트1", 3),
                            RaceResult.CarMoveResult("테스트2", 4)
                        )
                    )
                )
            }
        }
    }

    describe("getWinners") {

        context("경주가 종료되지 않았으면") {
            it("예외가 발생한다.") {
                shouldThrowWithMessage<IllegalStateException>("아직 경기가 종료되지 않았습니다.") {
                    race.getWinners()
                }
            }
        }

        context("경주가 종료되었으면") {
            race.start()

            it("우승자의 이동 결과를 반환한다.") {
                race.getWinners() shouldBe listOf(
                    RaceResult.CarMoveResult("테스트2", 4)
                )
            }
        }
    }
})
