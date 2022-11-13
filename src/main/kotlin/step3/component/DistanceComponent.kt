package step3.component

import step3.Position

class DistanceComponent(
    val position: Position,
) : Component {
    override fun render() {
        repeat(position.value) { print("-") }
    }
}
