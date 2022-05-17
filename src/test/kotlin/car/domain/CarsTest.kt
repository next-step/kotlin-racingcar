package car.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class CarsTest : StringSpec({
    "자동차 일급 컬렉션 생성 가능하다" {
        shouldNotThrow<Throwable> { Cars(carNames) }
    }

    "자동차 수가 1보다 작을시 Exception을 던진다" {
        shouldThrow<IllegalArgumentException> { Cars(carNames = emptyList()) }
    }

    "자동차가 움직일떄 마다 위치값을 리턴한다" {
        val cars = Cars(carNames)

        val move = cars.move { true }

        move.forAll { car ->
            car.position.value shouldBe 1
        }
    }

    "자동차 경주 우승자를 반환할수 있다." {
        val cars = Cars(carNames)

        cars.move { true }

        cars.findWinners().size shouldNotBe 0
    }
}) {
    companion object {
        private val carNames = listOf("A", "AB", "ABC")
    }
}
