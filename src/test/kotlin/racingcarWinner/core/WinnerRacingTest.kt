package racingcarWinner.core

import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class WinnerRacingTest {

    private var winner = Winner()

    @BeforeEach
    fun setUp() {
        winner = Winner()
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi,crong,honux", "pobi,crong,honux,alen", "pobi , crong "])
    fun setCar(carNames: String) {
        val carNameList = carNames.split(",")
        val cars = WinnerRacing().setCars(carNameList)

        cars.count() shouldBe carNameList.count()
        cars.forEachIndexed { index, car ->
            car.carName shouldBe carNameList[index].trim()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi,crong,honux", "pobi,crong,honux,alen"])
    fun startRacing(carNames: String) {
        val tryNumber = 3
        val racing = WinnerRacing()
        val cars = racing.setCars(carNames.split(","))

        val moveResult = racing.startRacing(cars = cars, winner = winner, tryNumber = tryNumber)

        moveResult.count() shouldBe cars.count()
        moveResult.keys.toList() shouldBe cars.map { car -> car.carName }
        moveResult.forEach { carMap ->
            carMap.value shouldBeLessThanOrEqual tryNumber
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, Int.MIN_VALUE])
    fun `startRacing throw Exception when tryNumber is Incorrect`(tryNumber: Int) {
        val carNames = "pobi,crong,honux"
        val racing = WinnerRacing()
        val cars = racing.setCars(carNames.split(","))

        val exception = assertThrows<IllegalArgumentException> {
            racing.startRacing(cars = cars, winner = winner, tryNumber = tryNumber)
        }

        Assertions.assertThat(exception.message).isEqualTo(MessageCode.TryNumberException.message)
    }

    @ParameterizedTest
    @ValueSource(strings = [ "pobi", "alen"])
    fun `startRacing throw Exception when carNumber is one`(carNames: String) {
        val tryNumber = 3
        val racing = WinnerRacing()
        val cars = racing.setCars(carNames.split(","))
        val exception = assertThrows<IllegalArgumentException> {
            racing.startRacing(cars = cars, winner = winner, tryNumber = tryNumber)
        }

        Assertions.assertThat(exception.message).isEqualTo(MessageCode.CarNumberException.message)
    }
}
