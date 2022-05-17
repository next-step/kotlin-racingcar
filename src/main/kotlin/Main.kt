import racing.scene.InputScene
import racing.scene.PlayScene
import racing.utils.RandomGenerator
import racing.utils.StandardInputSystem
import racing.utils.StandardOutputPainter

fun main() {
    val output = StandardOutputPainter()
    val input = StandardInputSystem()

    val inputDto = InputScene(output, input).run()

    val randomGenerator = RandomGenerator(0, 9)
    val scoreBoard = PlayScene(inputDto, output, randomGenerator).run()
    scoreBoard.draw()
}
