# Gemini integration telegram


## :pencil2: Description 
This project aims to provide a project basis that involves integration into Telegram and AI GEMINI.

The AI model used is gemini-pro with limitations in its free model that are detailed in the following documentation:[free model](https://ai.google.dev/pricing)

For more details about GEMINI:[GEMINI](https://ai.google.dev/)

## 💻Project Idea

The idea consists of using the Gemini API call using the lib unirest, where the content that will be handled by the IA will be provided through a conversation with a Telegram bot.

Following a flow:
- User --> Bot --> GEMINI (processing) GEMINI --> Bot --> User
## 👷How to run

It is necessary to inform some environmental variables, including:

- BOT_NAME: Name of your bot on Telegram.
- TOKEN_BOT: Bot token generated in BotFather.
- TOKEN_GEMINI: API Key for using GEMINI.
- URL: GEMINI API Url

For more details on how to create your Telegram bot, see the following documentation:[BotFather Documentation](https://core.telegram.org/bots/tutorial)

For more details on how to obtain your Gemini API key, see the following documentation:[GEMINI Documentation](https://ai.google.dev/)

```bash
# Clone the repository
git clone https://github.com/marlo2222/gemini-integration-telegram
# Enter directory
# Download dependencies
gradle build
# Run the server
gradle :botRun
```

## 📄License
This project is licensed under the [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0). See the [LICENSE](LICENSE) file for more details.
