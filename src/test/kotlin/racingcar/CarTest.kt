package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ValueSource(ints = [5, 6, 7])
    @ParameterizedTest
    fun `자동차는 위치를 가진다`(position: Int) {
        val car = Car(position)
        car.position shouldBe position
    }

    @Test
    fun `자동차의 초기 위치를 0이다`() {
        val car = Car()
        car.position shouldBe 0
    }

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `자동차는 무작위 값이 4 이상일 경우 움직인다`(condition: Int) {
        val car = Car()
        car.move(condition) { it >= 4 }
        car.position shouldBe 1
    }
}
