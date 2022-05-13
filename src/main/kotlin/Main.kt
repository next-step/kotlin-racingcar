import engine.EnvironmentManager
import engine.GameEngine
import engine.InMemoryEnvironmentModule
import model.ScoreBoard
import scene.InputScene
import scene.PlayScene
import utils.RandomGenerator
import utils.StandardInputSystem
import utils.StandardOutputPainter

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
