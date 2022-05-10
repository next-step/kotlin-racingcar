import model.ScoreBoard
import scene.InputScene
import scene.PlayScene
import utils.StandardInputSystem
import utils.StandardOutputPainter

fun main() {
    val output = StandardOutputPainter()
    val input = StandardInputSystem()
    val inputScene = InputScene(output, input)
    val inputResult = inputScene.update()
    val playScene = PlayScene(output, inputResult)
    playScene.forEach(ScoreBoard::draw)
}
