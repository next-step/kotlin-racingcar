package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @Test
    fun `Car 이동시 거리값 변경 확인`() {
        val testCar = Car(4)
        assertThat(
            testCar.run {
                move(4)
                getMovedDistance()
            }
        ).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `불가능한 이동 값 입력`(wrongValue: Int) {
        val car = Car(4)
        assertThat(car.isMoveAble(wrongValue)).isFalse
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `이동 가능한 값 입력`(moveAbleValue: Int) {
        val car = Car(4)
        assertThat(car.isMoveAble(moveAbleValue)).isTrue()
    }
}
