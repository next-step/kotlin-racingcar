package model
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import kotlin.random.Random

class CarTest {

    @Test
    @DisplayName("자동차 객체 생성")
    fun carCreation() {
        val carName = "12345"
        val car = Car(carName)

        assertEquals(carName, car.name)
        assertEquals(0, car.getPosition())
    }

    @Test
    @DisplayName("Random 4 이상일 때 자동차 전진")
    fun movePositionWhenRandomNumberIsGreaterThanOrEqualTo4() {
        val car = TestCar("12345", 4)
        val initialPosition = car.getPosition()

        car.move()
        assertEquals(initialPosition + 1, car.getPosition())
    }

    @Test
    @DisplayName("난수가 4 미만일 때 자동차 멈춤")
    fun stayPositionWhenRandomNumberIsLessThan4() {
        val car = TestCar("12345", 3)
        val initialPosition = car.getPosition()

        car.move()
        assertEquals(initialPosition, car.getPosition())
    }
}

/**
 *  테스트용 Car (fix random number)
 */
class TestCar(name: String, private val fixedRandomNum: Int) : Car(name) {
    override fun generateRandomNumber(): Int {
        return fixedRandomNum
    }
}