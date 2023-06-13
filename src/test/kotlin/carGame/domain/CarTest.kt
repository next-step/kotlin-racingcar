package carGame.domain

import carGame.test.FakeGenerator
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "[move 테스트] 호출하면 전진한다." {
        val car = FakeGenerator.generateCar(position = 0)
        val movedCar = car.move()

        movedCar.position shouldBe 1
    }
})
