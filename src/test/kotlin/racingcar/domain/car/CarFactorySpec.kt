package racingcar.domain.car

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.types.shouldBeInstanceOf

class CarFactorySpec : StringSpec({
    "자동차 이름을 입력받아 해당 이름을 가진 racingcar.domain.car.Car 인스턴스를 반환한다" {
        // arrange
        val carNames = listOf("pobi", "crong", "honux")

        // act
        val cars = CarFactory.create(carNames)

        // assert
        cars shouldHaveSize carNames.size
        cars.shouldForAll {
            it.shouldBeInstanceOf<Car>()
            carNames.contains(it.name)
        }
    }
})
