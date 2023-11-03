package racingcar.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe
import racingcar.domain.car.Car
import racingcar.domain.car.CarName

class CarRacingRefereeTest : FunSpec({

    test("가장 멀리간 차를 우승자로 반환한다") {
        val farthestCarName = CarName("test1")
        val farthestPosition = 10
        val cars = listOf(
            Car(farthestCarName, farthestPosition),
            Car(CarName("test2"), 3),
            Car(CarName("test3"), 9)
        )

        val result = CarRacingReferee.getWinners(cars)

        result.size shouldBe 1
        result[0].name shouldBe farthestCarName
        result[0].position shouldBe farthestPosition
    }

    test("가장 멀리간 차가 여러 대인 경우 여러 대를 우승자로 반환한다") {
        val farthestCarNames = listOf(CarName("test1"), CarName("test2"))
        val farthestPosition = 10
        val cars =
            listOf(
                Car(farthestCarNames[0], farthestPosition),
                Car(farthestCarNames[1], farthestPosition),
                Car(CarName("test3"), 0),
                Car(CarName("test4"), 3)
            )

        val result = CarRacingReferee.getWinners(cars)

        result.size shouldBe 2
        result[0].name.shouldBeIn(farthestCarNames)
        result[1].name.shouldBeIn(farthestCarNames)
        result[0].position.shouldBeIn(farthestPosition)
        result[1].position.shouldBeIn(farthestPosition)
    }

    test("차 리스트가 비어 있다면 우승자는 반환되지 않는다") {
        val cars = listOf<Car>()

        val result = CarRacingReferee.getWinners(cars)

        result.size shouldBe 0
    }
})
