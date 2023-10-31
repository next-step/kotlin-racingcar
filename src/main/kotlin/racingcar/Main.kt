package racingcar

fun main() {
    val racingCarService = RacingCarService(
        DependencyConfig.inputProvider,
        DependencyConfig.outputProvider,
    )

    racingCarService.run()
}
