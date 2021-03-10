package racingcar.tasks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car

internal class GameTest {

    @Test
    fun `자동차 경주 결과 상태 값 테스트`() {
        val cars = listOf(
            Car(name = "김대겸").apply {
                tryMove(true)
            },
            Car(name = "이영현").apply {
                tryMove(true)
                tryMove(true)
            },
            Car(name = "박재성").apply {
                tryMove(true)
                tryMove(true)
                tryMove(true)
            }
        )

        val mockSymbols = listOf("김대겸 : -", "이영현 : --", "박재성 : ---")

        cars.forEachIndexed { index, car ->
            assertThat("$car : ${car.whereIs()}").isEqualTo(mockSymbols[index])
        }
    }
}
