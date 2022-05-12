import engine.GameEngine
import model.ScoreBoard
import scene.InputScene
import scene.PlayScene
import utils.RandomGenerator
import utils.StandardInputSystem
import utils.StandardOutputPainter

fun main() {
    val output = StandardOutputPainter()
    val input = StandardInputSystem()
    val inputScene = InputScene(output, input)

    val scoreBoard = ScoreBoard(output)
    val randomGenerator = RandomGenerator(0, 9)
    val playScene = PlayScene(output, scoreBoard, randomGenerator)

    listOf(inputScene, playScene).forEach(GameEngine::run)
}
