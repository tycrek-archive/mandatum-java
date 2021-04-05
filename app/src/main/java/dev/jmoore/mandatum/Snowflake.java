package dev.jmoore.mandatum;

import net.dv8tion.jda.api.entities.ISnowflake;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Snowflake implements ISnowflake {
    private final String snowflake;

    /**
     * Creates a new Snowflake
     *
     * @see <a href="https://github.com/twitter-archive/snowflake/tree/snowflake-2010">GitHub: twitter-archive/snowflake</a>
     * @param snowflake The Snowflake value
     */
    @NotNull
    public Snowflake(String snowflake) {
        this.snowflake = snowflake;
    }

    /**
     * Creates a new Snowflake
     *
     * @see <a href="https://github.com/twitter-archive/snowflake/tree/snowflake-2010">GitHub: twitter-archive/snowflake</a>
     * @param snowflake The Snowflake value
     */
    @NotNull
    public Snowflake(long snowflake) {
        this.snowflake = Long.toString(snowflake);
    }

    /**
     * @return The Snowflake as a String
     */
    @NotNull
    @Override
    public String getId() {
        return this.snowflake;
    }

    /**
     * @return The Snowflake as a Long
     */
    @Override
    public long getIdLong() {
        return Long.parseLong(this.snowflake);
    }

    /**
     * Parses the timestamp out of the Snowflake (as per Twitter spec)
     *
     * @return The Snowflake's timestamp
     * @see <a href="https://discord.com/developers/docs/reference#snowflakes">Discord Developers reference: snowflakes</a>
     */
    @NotNull
    @Override
    public OffsetDateTime getTimeCreated() {
        return OffsetDateTime.ofInstant(Instant.ofEpochMilli((Long.parseLong(this.snowflake) >> 22) + 1420070400000L), ZoneOffset.UTC.normalized());
    }

    /**
     * @return The Snowflake as a String
     */
    @Override
    public String toString() {
        return this.snowflake;
    }
}
