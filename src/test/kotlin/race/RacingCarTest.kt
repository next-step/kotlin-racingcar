package race

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import race.model.Car
import race.model.Race

class RacingCarTest : StringSpec({
    "Car 움직임 2번 테스트" {
        val car = Car()
        car.move()
        car.move()
        car.position shouldBe 2
    }

    "Car 5대 생성 테스트 " {
        val race = Race(5)
        race.cars.size shouldBe 5
    }

    "Car 4 이상일 경우 움직임" {
        val race = Race(1)
        race.go(number = 3)
        race.cars.first().position shouldBe 0
        race.go(number = 4)
        race.cars.first().position shouldBe 1
        race.go(number = 4)
        race.cars.first().position shouldBe 2
    }

})
