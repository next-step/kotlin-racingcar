package racing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racing.MoveStrategy

class CarTest : StringSpec({
    "moveStrategy가 true일 때, 자동차는 움직일 수 있다." {
        val moveStrategy = MoveStrategy { true }
        val car = Car(moveStrategy = moveStrategy, name = Name.of("Toto"))

        car.move()

        car.distance shouldBe 1
    }

    "moveStrategy가 false이면, 자동차는 움직이지 않는다." {
        val moveStrategy = MoveStrategy { false }
        val car = Car(moveStrategy = moveStrategy, name = Name.of("Toto"))

        car.move()

        car.distance shouldBe 0
    }
})
