package racing.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import racing.service.GameMachine

class CarTest {

    @Test
    fun `레이싱카 이름은 쉼표로 기준으로 구분`() {
        val carNames = "a,b,c"
        val racing = Racing(carNames.split(","), 1)
        Assertions.assertEquals(racing.cars.size, 3)
    }

    @Test
    fun `레이싱카 이름은 1글자 이상 5글자이하`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            Car("")
        }
    }

    @Test
    fun `우승자는 두대 이상이다`() {
        val racing = Racing(listOf("car1", "car2", "car3"), 3)
        racing.cars[0].position = 10
        racing.cars[1].position = 10
        racing.cars[2].position = 1

        val winnigCar = GameMachine.getWinningCarName(racing)
        Assertions.assertEquals(winnigCar.size, 2)
    }

    @Test
    fun `경주가 완료후 가장 멀리간 자동차가 우승`() {
        val racing = Racing(listOf("car1", "car2"), 3)
        racing.cars[0].position = 10
        racing.cars[1].position = 1

        val winnigCar = GameMachine.getWinningCarName(racing)
        Assertions.assertEquals(winnigCar[0].name, "car1")
    }
}
