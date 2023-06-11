package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racing.domain.Car
import racing.generator.DefaultRandomMoveCheckGenerator
import java.io.ByteArrayInputStream
import java.io.InputStream

class RacingTest {

    @ParameterizedTest
    @CsvSource("3,3")
    fun `자동차 경주 입력 검증`(carCount: String, tryCount: String) {

        System.setIn(getInputStream(carCount))
        val inputCar = readln()

        System.setIn(getInputStream(tryCount))
        val inputTry = readln()

        assertThat(inputCar).isEqualTo(carCount)
        assertThat(inputTry).isEqualTo(tryCount)
    }

    private fun getInputStream(input: String): InputStream {
        val inputBytes = input.toByteArray()
        return ByteArrayInputStream(inputBytes)
    }

    @ParameterizedTest
    @CsvSource("3")
    fun `자동차 입력 수 만큼 객체 생성 검증`(carCount: Int) {
        val cars = Racing().createCars(carCount)
        assertThat(cars.size).isEqualTo(carCount)
    }

    @ParameterizedTest
    @CsvSource("5")
    fun `4 이상의 랜덤 숫자가 나와 자동차 이동 검증`(randomNumber: Int) {

        val car = Car(moveFlag = DefaultRandomMoveCheckGenerator(randomNumber))
        Racing().getCarPosition(car)
        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource("3")
    fun `4 이상의 랜덤 숫자가 나오지 않을 시 자동차 정지 검증`(randomNumber: Int) {

        val car = Car(moveFlag = DefaultRandomMoveCheckGenerator(randomNumber))
        Racing().getCarPosition(car)
        assertThat(car.position).isEqualTo(0)
    }
}
