package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.exception.Exception.Companion.CASE_WRONG_RANDOM_VALUE
import racingcar.model.Car
import racingcar.model.RaceCondition
import racingcar.model.move

class RacingCarTest {
    @Test
    @DisplayName("자동차 객체 생성 테스트")
    fun check_car_list_count() {
        val list = Cars(RaceCondition(3, 5)).carList
        assertThat(list.size).isEqualTo(3)
    }

    @Test
    @DisplayName("전진 테스트")
    fun check_move_forward() {
        val car = Car(movement = 0)
        car.move(6)
        assertThat(car.movement).isEqualTo(1)
    }

    @Test
    @DisplayName("정지 테스트")
    fun check_move_stop() {
        val car = Car(movement = 0)
        car.move(3)
        assertThat(car.movement).isEqualTo(0)
    }

    @Test
    @DisplayName("잘못된 랜덤값 테스트")
    fun check_wrong_random_value() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                val car = Car(movement = 0)
                car.move(10)
            }
            .withMessage(CASE_WRONG_RANDOM_VALUE)
    }

    @Test
    @DisplayName("이동 결과 테스트")
    fun check_result() {
        val tryCount = 3
        val randomInt = listOf(2, 5, 6)
        val car = Car(movement = 0)

        for (i in 0 until tryCount) {
            car.move(randomInt[i])
        }

        assertThat(car.movement).isEqualTo(2)
    }
}
