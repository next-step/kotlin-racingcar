package race

typealias CarName = String
typealias MoveCount = Int

data class RaceRound(val round: List<Pair<CarName, MoveCount>>)
