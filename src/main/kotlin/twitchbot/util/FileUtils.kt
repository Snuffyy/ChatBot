package twitchbot.util

import java.util.*

object FileUtils {

    fun loadResourceAsProperties(file: String): Properties {

        return Properties().apply {
            FileUtils::class.java.classLoader.getResourceAsStream(file)
                    .use { load(it) }
        }
    }
}