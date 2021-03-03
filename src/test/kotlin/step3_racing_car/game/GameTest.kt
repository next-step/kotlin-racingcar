package step3_racing_car.game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class GameTest {

    @TestFactory
    fun moveTest(): Collection<DynamicTest> {
        /*
            desc: random number에 따라 결과값이 증가할수도 있고, 아닐수도 있음.
         */

        // given
        val numOfCar = 5
        Player.register(numOfCar)
        // when
        Game.move(Player.cars)
        // then
        return Player.cars.map {
            DynamicTest.dynamicTest("Check position $it > 0") {
                assertThat(it.position >= 0).isTrue()
            }
        }.toList()
    }
}
