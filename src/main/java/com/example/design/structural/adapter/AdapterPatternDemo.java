package com.example.design.structural.adapter;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        player.play("mp3", "song.mp3");
        player.play("mp4", "video.mp4");
        player.play("vlc", "movie.vlc");
        player.play("avi", "clip.avi");
    }
}
