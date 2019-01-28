package twitchbot

import java.util.*

class Credentials(file: String) {

    private val properties: Properties = Helper().getProperties(file)
    internal val accessToken
        get() = properties.getProperty("access_token")
    internal val botName
        get() = properties.getProperty("bot_name")

    class Helper {

        fun getProperties(fileName: String): Properties {
            val properties = Properties()

            Helper::class.java.classLoader.getResourceAsStream(fileName)
                    .use { properties.load(it) }

            return properties
        }
    }
}