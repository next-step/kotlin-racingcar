import gameobj.ScoreBoard
import gameobj.StandardInputSystem
import gameobj.StandardOutputPainter
import scene.InputScene
import scene.PlayScene

fun main() {
    val output = StandardOutputPainter()
    val input = StandardInputSystem()
    val inputScene = InputScene(output, input)
    val inputResult = inputScene.update()
    val playScene = PlayScene(output, inputResult)
    playScene.forEach(ScoreBoard::draw)
}
