import racing.model.ScoreBoard
import racing.scene.InputScene
import racing.scene.PlayScene
import racing.scene.ResultScene
import racing.utils.RandomGenerator
import racing.utils.StandardInputSystem
import racing.utils.StandardOutputPainter

fun main() {
    val output = StandardOutputPainter()
    val input = StandardInputSystem()

    val inputScene = InputScene(output, input)
    val inputDto = inputScene.getGameInformation()

    val randomGenerator = RandomGenerator(0, 9)
    val playScene = PlayScene(inputDto, randomGenerator)
    val history = playScene.playGame()

    val resultScene = ResultScene(ScoreBoard(history), output)
    resultScene.draw()
}
