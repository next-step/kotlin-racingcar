package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ValueSource(ints = [5, 6, 7])
    @ParameterizedTest
    fun `자동차는 위치를 가진다`(position: Int) {
        val car = Car(name = "김민균", position = position)
        car.position shouldBe position
    }

    @Test
    fun `자동차의 초기 위치를 0이다`() {
        val car = Car("김민균")
        car.position shouldBe 0
    }

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `자동차는 무작위 값이 4 이상일 경우 움직인다`(condition: Int) {
        val car = Car("김민균")
        car.move(condition) { it >= 4 }
        car.position shouldBe 1
    }

    @ValueSource(strings = ["test", "names", "mkkim"])
    @ParameterizedTest
    fun `각 자동차에 이름을 부여할 수 있다`(param: String) {
        val car = Car(name = param)
        car.name shouldBe param
    }

    @ValueSource(strings = ["하나둘셋넷다섯", "일이삼사오육"])
    @ParameterizedTest
    fun `문자열 길이가 5자를 초과할 경우 자동차 이름은 5자를 초과할 수 없습니다`(param: String) {
        assertThrows<IllegalArgumentException> { Car(name = param) }
    }
}
