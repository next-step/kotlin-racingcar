package racingcar.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarsTest : FunSpec({
    context("자동차들의 이름과 위치를 구할수 있다") {
        val cars = Cars(listOf(Car("pobi"), Car("crong"), Car("honux")))
        cars.namesAndPositions shouldBe listOf(
            Pair("pobi", 0),
            Pair("crong", 0),
            Pair("honux", 0),
        )
    }

    context("자동차들 중 승자를 구할 수 있다") {
        val cars = Cars(
            listOf(
                Car(CarName("pobi"), WinnerConditionGenerator()),
                Car(CarName("crong")),
                Car(CarName("honux")),
            ),
        )
        val firstCar = cars.cars.first()
        firstCar.move()

        cars.winners shouldBe listOf(
            firstCar,
        )
    }
})
