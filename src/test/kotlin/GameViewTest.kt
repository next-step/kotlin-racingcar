import game.view.DELIMITER
import game.view.GameView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameViewTest {
    @Test
    fun 라운드_진행_결과_시각화() {
        val gameView = GameView()

        val result = gameView.showResult(listOf(1, 2, 3))

        val resultToList = result.split(DELIMITER).filter { it.isNotEmpty() }

        resultToList.forEach { assertThat(it).isEqualTo("-".repeat(it.length)) }
    }
}
