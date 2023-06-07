package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @Test
    fun `자동차는 현재 위치를 가진다`() {
        val actual = Car(1)
        actual.position shouldBe 1
    }

    @Test
    fun `자동차의 초기 위치는 0이다`() {
        val actual = Car()
        actual.position shouldBe 0
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 6, 9])
    fun `자동차는 4~9의 값이 입력되는 경우 1칸 전진한다`(input: Int) {
        val car = Car(position = 1)

        val actual = car.move(input)
        actual shouldBe 2
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 3])
    fun `자동차는 0~3의 값이 입력되는 경우 위치가 변하지 않는다`(input: Int) {
        val car = Car(position = 1)

        val actual = car.move(input)
        actual shouldBe 1
    }
}
