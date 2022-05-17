package step3.racing

class RacingTrack(racerCount: Int, val times: Int) {
  val racers: List<Car> = buildList {
    repeat(racerCount) { add(Car()) }
  }

  fun start() = repeat(times) {
    racers.forEach {
      it.run()
    }
    println()
  }
}
