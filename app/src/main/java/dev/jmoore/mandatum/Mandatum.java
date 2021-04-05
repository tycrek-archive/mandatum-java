package dev.jmoore.mandatum;

import io.github.cdimascio.dotenv.Dotenv;

import javax.security.auth.login.LoginException;

public class Mandatum {
    public static Dotenv DOTENV;
    public static Bot bot;

    public static void main(String[] args) throws LoginException, InterruptedException {
        // Load environment variables (including bot token)
        DOTENV = Dotenv.load();

        // Start the bot
        bot = new Bot(DOTENV.get("TOKEN"), new Snowflake("324679696182673408")).build();
    }
}
