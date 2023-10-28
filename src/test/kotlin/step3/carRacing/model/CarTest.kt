package step3.carRacing.model

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import step3.carRacing.Car
import io.kotest.core.spec.style.StringSpec

class CarTest : StringSpec({
    "자동차는 전진 또는 멈출 수 있다" {
        val car = Car()
        car.tryRace();

//        val stopCar = car.start(MoveNeverStrategy())
//        stopCar.id shouldBe car.id
//        stopCar.position shouldBe car.position
//
//        val unstoppableCar = car.start(MoveAlwaysStrategy())
//        unstoppableCar.id shouldBe car.id
//        unstoppableCar.position shouldBe car.position + 1
    }
})
