package racing

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차 forward 테스트`() {
        val car = Car("TestCar")
        val movingRule =  RacingMovingRule(1)
        car.forward(movingRule)

        if(movingRule.isMove()){
            assertTrue(car.route == 1)
        }
        else{
            assertTrue(car.route == 0)
        }
    }
}
