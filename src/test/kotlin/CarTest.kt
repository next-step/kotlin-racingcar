import controller.Winner
import domain.Car
import domain.Cars
import exception.InvalidCarNameException
import org.assertj.core.api.Assertions.assertThat
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

    @DisplayName("자동차 이름이 없는 경우")
    @Test
    fun blankCarName() {
        assertThrows(InvalidCarNameException::class.java) {
            Car("", 0)
        }
    }

    @DisplayName("자동차의 거리를 입력하지 않은 경우")
    @Test
    fun noCarDistanceParameter() {
        val car = Car("car1")

        assertThat(car.distance).isEqualTo(0);
    }

    @DisplayName("자동차가 움직이는 경우")
    @Test
    fun carMove() {
        var car = Car("car1")
        car.move()
        assertThat(car.distance).isEqualTo(1);
    }

    @DisplayName("자동차의 거리값으로 null이 오는 경우")
    @Test
    fun nullCarDistance() {
        var car = Car("car1", null)
        assertThat(car.distance).isEqualTo(0);
    }

    @DisplayName("자동차 이름이 여러개가 오고 올바르지 않은 값인 경우")
    @Test
    fun invalidNames() {
        val inputNames = "test1, test2, test3 ,tes tt"

        assertThrows(InvalidCarNameException::class.java) {
            for (carName in inputNames.split(",")) {
                Car(carName, 0)
            }
        }
    }

    @DisplayName("우승자가 여러명인 경우")
    @Test
    fun printWinners() {

        val car1 = Car("winner1", 10)
        val car2 = Car("winner2", 10)
        val car3 = Car("winner3", 5)


        val cars = Cars(listOf<Car>(car1, car2, car3))
        print(assertThat(Winner(cars).findWinnerNames()).hasSize(2))
    }
}