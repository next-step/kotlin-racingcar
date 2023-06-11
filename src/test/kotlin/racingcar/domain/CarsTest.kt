package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.domain.CarTest.Companion.aCar
import racingcar.domain.Cars.Companion.createRandomMoveCars

class CarsTest {

    @Test
    fun `자동차 대수가 1보다 작으면 예외가 발생한다`() {
        val exception = shouldThrowExactly<IllegalArgumentException> { Cars(values = listOf()) }
        exception.message shouldBe "게임 생성에 필요한 자동차 대수는 1대 이상이어야 한다."
    }

    @Test
    fun `자동차들을 모두 움직인다`() {
        val cars = Cars(values = listOf(aCar(position = 0) { true }, aCar(position = 0) { true }))
        cars.run()

        cars[0].position shouldBe 1
        cars[1].position shouldBe 1
    }

    @Test
    fun `현재 선두에 있는 자동차의 이름을 반환한다`() {
        val cars = Cars(
            listOf(
                aCar(position = 1, carName = CarName("1")),
                aCar(position = 2, carName = CarName("2"))
            )
        )
        val actual = cars.leadCarNames()

        actual shouldBe listOf("2")
    }

    @Test
    fun `랜덤하게 움직이는 자동차를 생성한다`() {
        val actual = createRandomMoveCars(carNames = listOf("pobi", "crong", "honux"))

        actual shouldHaveSize 3
    }
}
