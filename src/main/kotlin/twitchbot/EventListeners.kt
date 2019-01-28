package twitchbot

import net.engio.mbassy.listener.Handler
import org.kitteh.irc.client.library.event.channel.ChannelMessageEvent

class EventListeners {

    @Handler
    fun onChatMessage(event: ChannelMessageEvent) {

        if (event.actor.nick != event.client.nick) {
            event.channel.sendMessage("Chat message event listener WORKS!")
        }
    }

}