import domain.Car
import exception.InvalidCarNameException
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class CarTest {

    @DisplayName("자동차 이름이 없는 경우")
    @Test
    fun nullCarName() {
        assertThrows(InvalidCarNameException::class.java) {
            Car("", 0)
        }
    }
}