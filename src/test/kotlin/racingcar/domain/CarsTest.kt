package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

class CarsTest: StringSpec({

    "Cars는 일급 컬렉션으로써 1대 이상의 Car를 입력 받는다." {
        assertThrows(IllegalArgumentException::class.java) {
            Cars(emptyList())
        }.message shouldBe "자동차 수는 1대 이상이어야 합니다."
    }

    "Cars는 여러 대의 자동차에게 전진하라고 명령할 수 있다." {
        val car1 = Car(FixedEngine(5), "test1")
        val car2 = Car(FixedEngine(3), "test2")
        val car3 = Car(FixedEngine(8), "test3")

        for (i in 1..2) {
            Cars(listOf(car1, car2, car3)).move()
        }

        car1.getLocation() shouldBe 2
        car2.getLocation() shouldBe 0
        car3.getLocation() shouldBe 2
    }
})