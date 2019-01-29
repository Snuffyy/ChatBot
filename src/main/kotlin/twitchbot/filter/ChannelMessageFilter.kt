package twitchbot.filter

import org.kitteh.irc.client.library.event.channel.ChannelMessageEvent

class ChannelMessageFilter(event: ChannelMessageEvent) : Filter<ChannelMessageEvent>(event) {

    override fun filter() {
        if (event.actor.nick != event.client.nick) {
            event.channel.sendMessage("Chat message event listener WORKS!")
        }
    }
}