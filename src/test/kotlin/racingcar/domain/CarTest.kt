package racingcar.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.domain.Car.Companion.createRandomMoveCar

class CarTest {

    @Test
    fun `자동차는 현재 위치와 이름을 가진다`() {
        val actual = Car(position = 1, carName = CarName("pobi")) { true }
        actual.position shouldBe 1
        actual.name shouldBe "pobi"
    }

    @Test
    fun `자동차의 초기 위치는 0이다`() {
        val actual = Car(carName = CarName("pobi")) { true }
        actual.position shouldBe 0
    }

    @Test
    fun `movable이 true면 전진한다`() {
        val car = Car(position = 1, carName = CarName("pobi")) { true }
        val actual = car.move()
        actual shouldBe 2
    }

    @Test
    fun `movable이 false면 움직이지 않는다`() {
        val car = Car(position = 1, carName = CarName("pobi")) { false }
        val actual = car.move()
        actual shouldBe 1
    }

    @Test
    fun `랜덤하게 움직이는 차를 이름을 받아 생성한다`() {
        val actual = createRandomMoveCar(name = "pobi")

        actual.name shouldBe "pobi"
        actual.position shouldBe 0
    }

    companion object {
        fun aCar(
            position: Int = 0,
            carName: CarName = CarName(value = "pobi"),
            movable: () -> Boolean = { true }
        ) = Car(
            position = position,
            carName = carName,
            movable = movable
        )
    }
}
