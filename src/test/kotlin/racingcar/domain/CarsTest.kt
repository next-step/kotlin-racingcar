package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import racingcar.domain.condition.Condition

class CarsTest : StringSpec({
    "Cars는 Car list가 비어있을 때, 예외를 던진다." {
        val emptyCars = emptyList<Car>()

        shouldThrow<IllegalArgumentException> {
            Cars(emptyCars)
        }
    }

    "우승자 cars가 있을 때, 반환 된다." {
        val car1 = Car(
            2,
            CarName("test1"),
            object : Condition {
                override fun canMove(): Boolean = true
            }
        )
        val car2 = Car(
            3,
            CarName("test2"),
            object : Condition {
                override fun canMove(): Boolean = true
            }
        )
        val car3 = Car(
            3,
            CarName("test3"),
            object : Condition {
                override fun canMove(): Boolean = true
            }
        )
        val cars = Cars(listOf(car1, car2, car3))
        val winners = cars.getWinners()
        winners.size shouldBe 2
        winners shouldContain car2
        winners shouldContain car3
    }

    "중복된 carName이 있을 경우, 예외가 발생한다." {
        val car1 = Car(
            0,
            CarName("test1"),
            object : Condition {
                override fun canMove(): Boolean = true
            }
        )
        val car2 = Car(
            0,
            CarName("test1"),
            object : Condition {
                override fun canMove(): Boolean = true
            }
        )
        val cars = listOf(car1, car2)
        shouldThrow<IllegalArgumentException> {
            Cars(cars)
        }
    }
})
