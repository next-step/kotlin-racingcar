package racingcar

import domain.Car
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @Test
    fun `자동차는 이름과 위치를 가지고 있다`() {
        val car = Car("홍길동")
        car.name shouldBe "홍길동"
        car.position shouldBe 0
    }

    @Test
    fun `자동차 이름은 5자를 초과할 수 없다`() {
        shouldThrow<IllegalArgumentException> {
            Car("가나다마사")
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `자동차 전진 성공`(number: Int) {
        val car = Car("car1")
        car.move(number)
        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `자동차 전진 실패`(number: Int) {
        val car = Car("car1")
        car.move(number)
        assertThat(car.position).isEqualTo(0)
    }
}
