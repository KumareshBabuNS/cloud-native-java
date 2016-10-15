package com.siemesn.cms.tcp.netty;

import io.netty.channel.Channel;

import java.util.HashMap;

/**
 * Created by Z003MS0S on 9/29/2016.
 */
public class ChannelRepository {
    private HashMap<String, Channel> channelCache = new HashMap<String, Channel>();

    public ChannelRepository put(String key, Channel value) {
        channelCache.put(key, value);
        return this;
    }

    public Channel get(String key) {
        return channelCache.get(key);
    }

    public void remove(String key) { this.channelCache.remove(key); }

    public int size() {
        return this.channelCache.size();
    }
}
