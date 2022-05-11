package study.car

import car.domain.Cars
import car.ui.NumberOfCar
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CarsTest : StringSpec({
    "자동차 일급 컬렉션 생성 가능하다" {
        shouldNotThrow<Throwable> { Cars(numberOfCar = NumberOfCar(4)) }
    }

    "자동차 수가 1보다 작을시 Exception을 던진다" {
        shouldThrow<IllegalStateException> { Cars(numberOfCar = NumberOfCar(0)) }
        shouldThrow<IllegalStateException> { Cars(numberOfCar = NumberOfCar(-1)) }
    }

    "자동차가 움직일떄 마다 위치값을 리턴한다" {
        val cars = Cars(numberOfCar = NumberOfCar(4))

        val move = cars.move { true }

        move.forAll { position ->
            position.value shouldBe 1
        }
    }

})
