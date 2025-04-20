import controller.RacingController
import model.Car
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Assertions.*

class RacingControllerTest {

    private lateinit var controller: RacingController

    @BeforeEach
    fun setUp() {
        controller = RacingController()
    }

    @Test
    @DisplayName("자동차 생성 테스트")
    fun createCarsTest() {
        val carNames = listOf("car1", "car2", "car3")
        val cars = controller.createCars(carNames)

        assertEquals(3, cars.size)
        assertEquals("car1", cars[0].name)
        assertEquals("car2", cars[1].name)
        assertEquals("car3", cars[2].name)
    }

    @Test
    @DisplayName("레이스 진행 테스트")
    fun startRaceTest() {
        val car1 = TestCar("car1", false)
        val car2 = TestCar("car2", true)
        val cars = listOf(car1, car2)
        val attemptCount = 3

        val results = controller.startRace(cars, attemptCount)
        assertEquals(attemptCount, results.size)

        for (i in 0 until attemptCount) {
            val roundResult = results[i]
            // println(roundResult)

            assertTrue(roundResult.contains("car1 : "))

            val expectedDashes = "-".repeat(i + 1)
            assertTrue(roundResult.contains("car2 : $expectedDashes"))
        }

    }

    @Test
    @DisplayName("최종 우승자 결정 테스트")
    fun getWinnersTest() {
        val car1 = TestCar("car1", 4)
        val car2 = TestCar("car2", 5)
        val car3 = TestCar("car3", 5)
        val cars = listOf(car1, car2, car3)

        val winners = controller.getWinners(cars)
        assertEquals(2, winners.size)
        assertTrue(winners.any { it.name == "car2" })
        assertTrue(winners.any { it.name == "car3" })
    }
}

class TestCar(name: String, private val alwaysMove: Boolean) : Car(name) {
    private var position = 0

    constructor(name: String, fixedPosition: Int) : this(name, false) {
        position = fixedPosition
    }

    override fun generateRandomNumber(): Int {
        return if (alwaysMove) 5 else 1
    }

    override fun getPosition(): Int {
        return position
    }

    override fun move() {
        if (alwaysMove) {
            position++
        }
    }
}