import racing.engine.EnvironmentManager
import racing.engine.GameEngine
import racing.engine.InMemoryEnvironmentModule
import racing.model.ScoreBoard
import racing.scene.InputScene
import racing.scene.PlayScene
import racing.utils.RandomGenerator
import racing.utils.StandardInputSystem
import racing.utils.StandardOutputPainter

fun main() {
    val output = StandardOutputPainter()
    val input = StandardInputSystem()
    val environmentManager = EnvironmentManager(InMemoryEnvironmentModule())

    val inputScene = InputScene(output, input, environmentManager)

    val scoreBoard = ScoreBoard(output)
    val randomGenerator = RandomGenerator(0, 9)
    val playScene = PlayScene(output, scoreBoard, randomGenerator, environmentManager)

    listOf(inputScene, playScene).forEach(GameEngine::run)
}
