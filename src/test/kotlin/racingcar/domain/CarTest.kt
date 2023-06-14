package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.condition.Condition

class CarTest : StringSpec({
    "Car는 이동 조건이 충족 되었을 때, 이동해야 한다." {
        val car = Car(
            0,
            CarName("test"),
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
            CarName("test"),
            object : Condition {
                override fun canMove(): Boolean = false
            }
        )
        car.move()
        car.position shouldBe 0
    }

    "Car 이름이 동일한 경우, condition, position 상관 없이 같은 Car이다." {
        val car1 = Car(
            0,
            CarName("test"),
            object : Condition {
                override fun canMove(): Boolean = false
            }
        )
        val car2 = Car(
            10,
            CarName("test"),
            object : Condition {
                override fun canMove(): Boolean = true
            }
        )
        car1 shouldBe car2
    }
})
