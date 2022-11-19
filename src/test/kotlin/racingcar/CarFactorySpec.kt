package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.types.shouldBeInstanceOf

class CarFactorySpec : StringSpec({
    "지정한 수만큼 Car 인스턴스를 반환한다" {
        // arrange
        val size = 5
        val carFactory = CarFactory()

        // act
        val cars = carFactory.create(size)

        // assert
        cars shouldHaveSize size
        cars.shouldForAll {
            it.shouldBeInstanceOf<Car>()
        }
    }
})
