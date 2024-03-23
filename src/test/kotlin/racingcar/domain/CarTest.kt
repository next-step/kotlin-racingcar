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
        `when`("5글자 이상의 이름을 가지고 생성하면") {
            then("IllegalArgumentException이 발생한다.") {
                assertThrows(IllegalArgumentException::class.java) {
                    Car(FixedEngine(5), "5글자이상의이름")
                }
            }
        }
        `when`("5글자 이하의 이름을 가지고 생성하면") {
            then("정상적으로 생성된다.") {
                val car = Car(FixedEngine(5), "test")
                assertEquals("test", car.getName())
            }
        }
    }
})