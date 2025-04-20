import camp.nextstep.edu.model.Car
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CarTest {

    @Test
    fun createCar_validName() {
        val car = Car("pobi")
        assertEquals("pobi", car.name)
        assertEquals(0, car.position)
    }

    @Test
    fun createCar_nameTooLong() {
        assertThrows(IllegalArgumentException::class.java) {
            Car("tooLongName")
        }.apply {
            assertEquals("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.", message)
        }
    }

    @Test
    fun createCar_emptyName() {
        assertThrows(IllegalArgumentException::class.java) {
            Car("")
        }.apply {
            assertEquals("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.", message)
        }
    }

}