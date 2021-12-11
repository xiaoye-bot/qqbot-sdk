package me.zhenxin.qqbot.pojo;

import lombok.Data;

/**
 * 公告对象
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/11 13:16
 */
@Data
public class Announces {
    /**
     * 频道ID
     */
    private String guildId;
    /**
     * 子频道ID
     */
    private String channelId;
    /**
     * 消息ID
     */
    private String messageId;
}
