package step3.tasks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName

internal class GameTest {

    @Test
    @DisplayName("카운트 만큼 Car 생성")
    fun setting() {
        val game = Game()
        val carOfCount = 5
        val listOfCar = game.setting(carOfCount)

        assertThat(listOfCar.size).isEqualTo(carOfCount)
    }
}
