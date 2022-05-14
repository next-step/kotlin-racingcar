package study.car

import car.domain.Car
import car.domain.vo.Name
import car.domain.vo.Position
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "자동차를 생성할수 있다" {
        shouldNotThrow<Throwable> { `자동차 위치 0, 이름 A`() }
    }

    "자동차를 생성하면 위치가 0으로 초기회 된다" {
        val car = `자동차 위치 0, 이름 A`()

        car.position.value shouldBe 0
    }

    "자동차가 전진하는 경우 Position 값을 증가 시킨다." {
        val car = `자동차 위치 0, 이름 A`()
        car.move { true }

        car.position.value shouldBe 1
    }

    "자동차가 전진하지 않으면 Position 값이 증가하지 않는다." {
        val car = `자동차 위치 0, 이름 A`()
        car.move { false }

        car.position.value shouldBe 0
    }
}) {
    companion object {
        private fun `자동차 위치 0, 이름 A`() = Car(Name("A"), Position(0))
    }
}
