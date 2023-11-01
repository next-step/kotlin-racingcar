package racingcar.domain.result

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe
import racingcar.domain.car.Car
import racingcar.domain.car.CarName
import racingcar.domain.result.CarRacingResult

class CarRacingResultTest : FunSpec({
    test("가장 멀리간 차를 반환한다") {
        val farthestCarName = CarName("test1")
        val farthestPosition = 10
        val cars = listOf(
            Car(farthestCarName, farthestPosition),
            Car(CarName("test3"), 3),
            Car(CarName("test4"), 3)
        )

        val result = CarRacingResult(cars).getFarthestCar()

        result.size shouldBe 1
        result[0].name shouldBe farthestCarName
        result[0].position shouldBe farthestPosition
    }

    test("가장 멀리간 차가 여러 대인 경우 여러 대를 반환한다") {
        val farthestNames = listOf(CarName("test1"), CarName("test2"))
        val farthestNames2 = listOf("test1", "test2")
        val farthestPosition = 10
        val cars = listOf(
            Car(farthestNames[0], farthestPosition),
            Car(farthestNames[1], farthestPosition),
            Car(CarName("test3"), 3),
            Car(CarName("test4"), 3)
        )

        val result = CarRacingResult(cars).getFarthestCar()

        result.size shouldBe 2
        result[0].name.shouldBeIn(farthestNames)
        result[1].name.shouldBeIn(farthestNames)
        result[0].position shouldBe farthestPosition
        result[1].position shouldBe farthestPosition
    }
})
