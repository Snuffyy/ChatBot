package twitchbot

import org.kitteh.irc.client.library.Client
import org.kitteh.irc.client.library.feature.twitch.TwitchSupport

class TwitchClient {

    private val credentials = Credentials("twitch.properties")
    private val client = Client.builder()
            .server().host("irc.chat.twitch.tv").port(443)
            .password(credentials.accessToken).then()
            .nick(credentials.botName)
            .build()


    init {
        Initializer(client).init()
    }

    fun connect() {
        client.connect()
    }

    fun join(channel: String) {
        client.addChannel(channel)
    }


    class Initializer(private val client: Client) {

        internal fun init() {
            TwitchSupport.addSupport(client) // add twitch support to IRC client
            client.eventManager.registerEventListener(EventListeners()) // register event listeners
        }
    }
}