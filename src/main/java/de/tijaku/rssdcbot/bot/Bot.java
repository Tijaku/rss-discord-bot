package de.tijaku.rssdcbot.bot;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Bot {

    private JDA jda;
    private Dotenv config;

    public Bot() {
        config = Dotenv.configure().load();
        if(config.get("TOKEN") != null) {
            jda = buildJDA();

            System.out.println("Bot started!");
        } else {
            System.out.println("Bot could not get started.");
        }
    }

    private JDA buildJDA() {
        JDABuilder builder = JDABuilder.createDefault(config.get("TOKEN"), GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_VOICE_STATES);

        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.streaming("How to Java", "https://www.youtube.com/watch?v=QlPvfrB9TpQ"));
        return builder.build();
    }
}
