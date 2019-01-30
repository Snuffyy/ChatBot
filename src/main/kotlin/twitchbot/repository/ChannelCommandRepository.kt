package twitchbot.repository

interface ChannelCommandRepository {

    fun getResponseForCommand(channel: String, command: String) : String
}