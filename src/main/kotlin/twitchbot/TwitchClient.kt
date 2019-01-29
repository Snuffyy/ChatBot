package twitchbot

import org.kitteh.irc.client.library.Client
import org.kitteh.irc.client.library.feature.twitch.TwitchSupport
import java.text.SimpleDateFormat
import java.util.*

class TwitchClient {

    private val credentials = Credentials("twitch.properties")
    private val client = Client.builder()
            .server().host("irc.chat.twitch.tv").port(443)
            .password(credentials.accessToken).then()
            .nick(credentials.botName)
            .build()


    init {
        Initializer(client, debug = true).init()
    }

    fun connect() {
        client.connect()
    }

    fun join(channel: String) {
        client.addChannel(channel)
    }


    class Initializer(private val client: Client, private val debug: Boolean = false) {

        internal fun init() {
            TwitchSupport.addSupport(client) // add twitch support to IRC client
            client.eventManager.registerEventListener(EventListeners()) // register event listeners
            if (debug) enableDebug()
        }

        private fun enableDebug() {
            val dateFormatter = SimpleDateFormat("hh:mm:ss")

            client.setInputListener { line -> println("${dateFormatter.format(Date())} I $line") }
            client.setOutputListener { line -> println("${dateFormatter.format(Date())} O $line") }
            client.setExceptionListener(Throwable::printStackTrace)
        }
    }
}