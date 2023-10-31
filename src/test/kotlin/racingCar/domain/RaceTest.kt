package racingCar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingCar.helper.CarFixture
import racingCar.helper.RaceFixture

class RaceTest : DescribeSpec({

    describe("start") {
        val car = Car(name = CarName("테스트"), position = CarPosition(2))

        val race = Race(
            tryCount = TryCount(2),
            cars = Cars(
                cars = listOf(car),
                numberGenerator = CarFixture.makeFakeCarPowerGenerator(5)
            ),
            raceResult = RaceFixture.makeFakeRaceResult()
        )

        context("레이스 경주를 시작하면") {
            race.start()

            it("주어진 시도 횟수만큼 차들이 경주를 시작한다.") {
                car.position shouldBe CarPosition(4)
            }
        }
    }
})
