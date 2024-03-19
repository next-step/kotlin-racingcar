package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import org.junit.jupiter.api.Assertions.*
import racingcar.domain.Car

class CarTest: BehaviorSpec({

    given("Car는 ") {
        `when`("4이상의 값을 엔진으로부터 받으면") {
            then("전진한다.") {
                val car = Car(FixedEngine(5), "test").apply { move() }
                assertEquals(1, car.getLocation())
            }
        }
        `when`("4이하의 값을 엔진으로부터 받으면") {
            then("아무 일도 일어나지않는다.") {
                val car = Car(FixedEngine(3), "test").apply { move()}
                assertEquals(0, car.getLocation())
            }
        }
    }
})