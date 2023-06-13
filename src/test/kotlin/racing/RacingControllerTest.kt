package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import racing.controller.RacingController
import racing.domain.Car
import racing.view.InputView
import racing.view.ResultView
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.nio.charset.StandardCharsets

class RacingControllerTest {

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

    private fun getInputArrayStream(vararg inputValues: String): ByteArrayInputStream {
        val input = inputValues.joinToString(System.lineSeparator())
        return ByteArrayInputStream(input.toByteArray(StandardCharsets.UTF_8))
    }

    @ParameterizedTest
    @CsvSource("3")
    fun `자동차 입력 수 만큼 객체 생성 검증`(carCount: Int) {
        val cars = CarFactory().createCarsByInputCount(carCount)
        assertThat(cars.size).isEqualTo(carCount)
    }

    @ParameterizedTest
    @ValueSource(strings = ["car1,car2,car3"])
    fun `입력 받은 자동차 정보 객체 생성 검증`(inputCarName: String) {

        val cars = CarFactory().createCarsByInputCarName(inputCarName)
        assertThat(cars.size).isEqualTo(3)
        assertThat(cars[0].carName.name).isEqualTo("car1")
        assertThat(cars[1].carName.name).isEqualTo("car2")
        assertThat(cars[2].carName.name).isEqualTo("car3")
    }

    @ParameterizedTest
    @CsvSource("5")
    fun `4 이상의 랜덤 숫자가 나와 자동차 이동 검증`(randomNumber: Int) {

        val car = Car(name = "test", numberGenerator = DefaultNumberGenerator(randomNumber))
        car.move()
        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource("3")
    fun `4 이상의 랜덤 숫자가 나오지 않을 시 자동차 정지 검증`(randomNumber: Int) {

        val car = Car(name = "test", numberGenerator = DefaultNumberGenerator(randomNumber))
        car.move()
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `제일 많이 움직인 자동차 (중복 허용)조회(포지션 값이 제일 높은)`() {

        val cars = listOf(
            Car(name = "test1", numberGenerator = DefaultNumberGenerator(1)),
            Car(name = "test2", numberGenerator = DefaultNumberGenerator(1)),
            Car(name = "test3", numberGenerator = DefaultNumberGenerator(5)),
            Car(name = "test4", numberGenerator = DefaultNumberGenerator(5)),
        )

        cars.forEach { it.move() }

        val winners = RacingManager().getRaceWinnerCars(cars)
        assertThat(winners.size).isEqualTo(2)
    }

    @Test
    fun `레이싱 경주(우승자) 출력 결과`() {
        System.setIn(getInputArrayStream("car1,car2,car3", "3"))
        RacingController(InputView, ResultView).racingGame()
    }
}
