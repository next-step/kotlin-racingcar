package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racing.domain.Car
import racing.view.InputView
import java.io.ByteArrayInputStream
import java.io.InputStream

class RacingTest {

    @ParameterizedTest
    @CsvSource("3,3")
    fun `자동차 경주 입력 (자동차 수, 시도 수) 검증`(inputCar: String, inputTry: String) {

        System.setIn(getInputStream(inputCar))
        val carCount = InputView.printInputCar()

        System.setIn(getInputStream(inputTry))
        val tryCount = InputView.printInputCount()

        assertThat(carCount).isEqualTo(inputCar.toInt())
        assertThat(tryCount).isEqualTo(inputTry.toInt())
    }

    private fun getInputStream(input: String): InputStream {
        val inputBytes = input.toByteArray()
        return ByteArrayInputStream(inputBytes)
    }

    @ParameterizedTest
    @CsvSource("3")
    fun `자동차 입력 수 만큼 객체 생성 검증`(carCount: Int) {
        val cars = CarFactory().createCarsByInputCount(carCount)
        assertThat(cars.size).isEqualTo(carCount)
    }

    @ParameterizedTest
    @CsvSource("5")
    fun `4 이상의 랜덤 숫자가 나와 자동차 이동 검증`(randomNumber: Int) {

        val car = Car(name = "test", moveFlag = DefaultNumberGenerator(randomNumber))
        car.move()
        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource("3")
    fun `4 이상의 랜덤 숫자가 나오지 않을 시 자동차 정지 검증`(randomNumber: Int) {

        val car = Car(name = "test", moveFlag = DefaultNumberGenerator(randomNumber))
        car.move()
        assertThat(car.position).isEqualTo(0)
    }
}
