package step3.component

class DistanceComponent(
    val position: Int,
) : Component {
    override fun render() {
        repeat(position) { print("-") }
    }
}
