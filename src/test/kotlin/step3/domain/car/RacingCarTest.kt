package step3.domain.car

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import step3.domain.car.name.CarNameDataSet

class RacingCarTest : FunSpec({

    context("레이싱 카가 정상적으로 생성된다") {
        val testCount = 10
        withData(
            nameFn = { "RacingCar(\"$it\") 정상적으로 생성" },
            CarNameDataSet.testDataList(testCount)
        ) { carName ->
            RacingCar(carName) shouldNotBe null
        }
    }

    context("RacingCar.go() method 정상 작동") {
        withData(
            nameFn = { "When RacingCar.go() called $it times, then distance increase $it" },
            (0..4)
        ) { methodCallCount ->
            val racingCar = RacingCar(CarNameDataSet.testData())

            val beforeDistance = racingCar.carDistance.distance

            repeat(methodCallCount) {
                racingCar.go()
            }

            val afterDistance = racingCar.carDistance.distance

            afterDistance shouldBe beforeDistance + methodCallCount
        }
    }
})
