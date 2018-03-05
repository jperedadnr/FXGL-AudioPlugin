package com.gluonhq.impl.charm.down.plugins.android;

import android.media.MediaPlayer;
import com.gluonhq.impl.charm.down.plugins.Audio;
import com.gluonhq.impl.charm.down.plugins.AudioType;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public final class AndroidMusic extends Audio {

    private MediaPlayer mediaPlayer;

    public AndroidMusic(String fullName, MediaPlayer mediaPlayer) {
        super(AudioType.MUSIC, fullName);

        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void setLooping(boolean looping) {
        mediaPlayer.setLooping(looping);
    }

    @Override
    public void setVolume(double volume) {
        mediaPlayer.setVolume((float)volume, (float)volume);
    }

    @Override
    public void setOnFinished(Runnable action) {
        mediaPlayer.setOnCompletionListener(player -> action.run());
    }

    @Override
    public void play() {
        mediaPlayer.start();
    }

    @Override
    public void pause() {
        mediaPlayer.pause();
    }

    @Override
    public void stop() {
        mediaPlayer.stop();
    }

    @Override
    public void dispose() {
        mediaPlayer.release();
    }
}
