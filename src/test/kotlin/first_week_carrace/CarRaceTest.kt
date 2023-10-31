package first_week_carrace

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class CarRaceTest {

    @Test
    fun `자동차 경주 게임 테스트`() {
        val carRace = CarRace(listOf("a", "b", "c"))
        val carsPosition = carRace.getCarsPosition()
        assertThat(carsPosition).isEqualTo(listOf(Pair("a", 1), Pair("b", 1), Pair("c", 1)))
        assertThat(carsPosition.size).isEqualTo(3)
        assertThat(carRace.getWinners()).isEqualTo(listOf("a", "b", "c"))
    }

    @Test
    fun `이름이 5글자가 넘어가면 예외 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            CarRace(listOf("aaaaaa"))
        }
    }
}
