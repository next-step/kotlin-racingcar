package race

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import race.model.Car
import race.model.Race

class RacingCarTest : StringSpec({
    "Car 움직임 2번 테스트" {
        val car = Car(engine = EngineTest(10))
        car.go()
        car.go()
        car.position shouldBe 2
    }

    "Car 5대 생성 테스트 " {
        val race = Race(5)
        race.cars.size shouldBe 5
    }

    "Car power 4 이상일 경우 움직임" {
        val lowCar = Car(engine = EngineTest(1))
        lowCar.go()
        lowCar.position shouldBe 0

        val highCar = Car(engine = EngineTest(4))
        highCar.go()
        highCar.position shouldBe 1
    }
})
