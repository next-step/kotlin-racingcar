package racing

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import racing.model.Car
import racing.model.Car.Companion.INVALID_CAR_NAME_BLANK
import racing.model.Car.Companion.INVALID_CAR_NAME_LENGTH
import racing.model.Car.Companion.INVALID_CAR_POSITION

class CarTest {
    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car("test")
    }

    @ParameterizedTest
    @CsvSource(value = ["mee, 0", "a, 4", "messi, 0"])
    fun `올바른 자동차 생성자 테스트`(name: String, position: Int) {
        Car(name, position)
    }

    @ParameterizedTest
    @ValueSource(strings = ["kylian", "k     j"])
    fun `자동차 생성자 이름 길이 에러 테스트`(name: String) {
        assertThatIllegalArgumentException().isThrownBy {
            Car(name)
        }.withMessage(INVALID_CAR_NAME_LENGTH)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "    "])
    fun `자동차 생성자 이름 공백 에러 테스트`(name: String) {
        assertThatIllegalArgumentException().isThrownBy {
            Car(name)
        }.withMessage(INVALID_CAR_NAME_BLANK)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -10])
    fun `자동차 생성자 위치 에러 테스트`(position: Int) {
        assertThatIllegalArgumentException().isThrownBy {
            Car("test", position)
        }.withMessage(INVALID_CAR_POSITION)
    }

    @Test
    fun `자동차 전진 테스트`() {
        assertThat(car.move { true }).isEqualTo(1)
    }

    @Test
    fun `자동차 정지 테스트`() {
        assertThat(car.move { false }).isEqualTo(0)
    }
}
