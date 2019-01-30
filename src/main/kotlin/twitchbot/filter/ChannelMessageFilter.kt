package twitchbot.filter

import org.kitteh.irc.client.library.event.channel.ChannelMessageEvent
import twitchbot.repository.ChannelCommandRepository
import twitchbot.repository.ChannelCommandRepositoryImpl

open class ChannelMessageFilter(event: ChannelMessageEvent) : Filter<ChannelMessageEvent>(event) {

    override fun filter() {
        if (!isBot(event.actor.nick, event.client.nick)) {
            if (isCommand(event.message)) ChannelCommandFilter(event).next()
        }
    }

    private fun isBot(userNick: String, botNick: String) = userNick == botNick

    private fun isCommand(message: String) = message.trim().startsWith("!")

    class ChannelCommandFilter(event: ChannelMessageEvent) : ChannelMessageFilter(event) {

        fun next() {
            val channelCommandRepo: ChannelCommandRepository = ChannelCommandRepositoryImpl()
            val channel = event.channel.name
            val command = event.message
            val response = channelCommandRepo.getResponseForCommand(channel, command)

            if (response != "") event.channel.sendMessage(response)
        }

    }
}