package racing

typealias Random = (Int) -> Boolean

val canMoveForward: Random = { i -> (0..9).random() >= i }
