package twitchbot

import net.engio.mbassy.listener.Handler
import org.kitteh.irc.client.library.event.channel.ChannelMessageEvent
import twitchbot.filter.ChannelMessageFilter

class EventListeners {

    @Handler
    fun onChatMessage(event: ChannelMessageEvent) {
        ChannelMessageFilter(event).filter()
    }

}