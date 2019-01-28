# Advanced Twitch Chatbot

## Set up


Create **twitch.properties** file in the _resources_ folder with bot's credentials:

```properties
bot_name=[your_bot_twitch_name]
access_token=oauth:[your_bot_access_token]
```

### Access Token

Access token can be obtained with [Twitch Token Generator by swiftyspiffy](https://twitchtokengenerator.com/). 
For only reading chat and sending messages _chat:read_ and _chat:edit_ scopes are enough.