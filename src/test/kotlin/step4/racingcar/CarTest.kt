package step4.racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import step4.racingcar.domain.Car

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = ["molly", "jayce", "pug"])
    fun `자동차 생성 테스트`(input: String) {
        val cars = Car(input)

        assertEquals(cars.racerName, input)
    }

    @ParameterizedTest
    @ValueSource(ints = [5, 8, 9])
    fun `자동차 이동 성공 테스트`(input: Int) {
        val car = Car("성공")
        car.move(input)

        assertEquals(car.movements.count { it }, 1)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 3])
    fun `자동차 이동 실패 테스트`(input: Int) {
        val car = Car("실패")
        car.move(input)

        assertEquals(car.movements.count { it }, 0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["abcdef", "aaaaaa", "bbbbbb"])
    fun `자동차 이름 사이즈 5자 이상 오류 테스트`(input: String) {
        assertThrows<IllegalArgumentException> { Car(input) }
    }
}
