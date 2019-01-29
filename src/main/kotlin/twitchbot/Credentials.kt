package twitchbot

import twitchbot.util.FileUtils
import java.util.*

class Credentials(file: String) {

    private val properties: Properties = FileUtils.loadResourceAsProperties(file)
    internal val accessToken
        get() = properties.getProperty("access_token")
    internal val botName
        get() = properties.getProperty("bot_name")
}