package racingcar

fun main() {
    val racingCarService = RacingCarService(
        DependencyConfig.inputProvider,
        DependencyConfig.outputProvider,
        DependencyConfig.carFactory,
    )

    racingCarService.run()
}
