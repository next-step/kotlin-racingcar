package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.CarFactory

class CarFactoryTest : StringSpec({

    "자동차 이름 목록이 주어지면 동일한 수의 자동차 객체를 생성해야 합니다." {
        val carNames = listOf("테슬라", "제네시스", "기아")

        val createdCars = CarFactory.createsCars(carNames)

        createdCars.cars.size shouldBe carNames.size
    }

    "생성된 차량의 이름은 제공된 자동차 이름 목록과 동일해야 합니다." {
        val carNames = listOf("테슬라", "제네시스", "기아")

        val createdCars = CarFactory.createsCars(carNames)

        createdCars.cars.forEachIndexed { index, car ->
            car.name shouldBe carNames[index]
        }
    }
})
