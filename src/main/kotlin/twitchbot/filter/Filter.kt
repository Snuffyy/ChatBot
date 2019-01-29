package twitchbot.filter

import org.kitteh.irc.client.library.event.helper.ClientEvent

abstract class Filter<T>(val event: T) where T : ClientEvent {

    abstract fun filter()
}