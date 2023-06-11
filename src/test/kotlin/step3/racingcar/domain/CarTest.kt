package step3.racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import step3.racingcar.domain.condition.Condition

class CarTest : StringSpec({
    "Car는 이동 조건이 충족 되었을 때, 이동해야 한다." {
        val car = Car(
            0,
            object : Condition {
                override fun canMove(): Boolean = true
            }
        )
        car.move()
        car.position shouldBe 1
    }

    "Car는 이동 조건이 충족 되지 않았을 때, 이동하면 안된다." {
        val car = Car(
            0,
            object : Condition {
                override fun canMove(): Boolean = false
            }
        )
        car.move()
        car.position shouldBe 0
    }
})
