import game.view.GameView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameViewTest {
    @Test
    fun 라운드_진행_결과_시각화() {
        val gameView = GameView()
        val inputs = listOf(1, 2, 3)
        val result = gameView.showResult(inputs)
        val resultToList = result.split("\n").filter {
            it.isNotEmpty()
        }

        resultToList.forEachIndexed { index, line ->
            assertThat(line).isEqualTo("-".repeat(inputs[index]))
        }
    }
}
