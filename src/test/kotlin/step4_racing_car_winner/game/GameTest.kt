package step4_racing_car_winner.game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import step4_racing_car_winner.game.ui.MockReceiver

internal class GameTest {

    @TestFactory
    fun startTest(): Collection<DynamicTest> {
        /*
            desc: random number에 따라 결과값이 증가할수도 있고, 아닐수도 있음.
         */

        // given
        MockReceiver().name?.let { Player.register(it) }

        // when
        Game.start(MockReceiver())
        // then
        return Player.cars.map {
            DynamicTest.dynamicTest("Check position $it > 0") {
                assertThat(it.position >= 0).isTrue()
            }
        }.toList()
    }
}
