import model.ScoreBoard
import scene.InputScene
import scene.PlayScene
import utils.StandardInputSystem
import utils.StandardOutputPainter

fun main() {
    val output = StandardOutputPainter()
    val input = StandardInputSystem()

    val inputScene = InputScene(output, input)
    inputScene.fire()

    val scoreBoard = ScoreBoard(output)
    val playScene = PlayScene(scoreBoard)
    while (playScene.hasNext()) {
        playScene.fire()
    }
}
