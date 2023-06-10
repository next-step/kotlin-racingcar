package racingcar
import racingcar.service.RacingCarService

object RacingCarApplication {
    private val racingCarService = RacingCarService()

    @JvmStatic
    fun main(args: Array<String>) {
        racingCarService.play()
    }
}
