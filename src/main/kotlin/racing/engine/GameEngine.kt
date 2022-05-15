package racing.engine

import racing.scene.Scene

object GameEngine {

    fun run(scene: Scene) {
        scene.start()
        do {
            scene.update()
        } while (scene.hasNext())
        scene.onDestroy()
    }
}
