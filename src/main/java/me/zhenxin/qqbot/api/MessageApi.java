package me.zhenxin.qqbot.api;

import cn.hutool.json.JSONUtil;
import me.zhenxin.qqbot.pojo.Message;
import me.zhenxin.qqbot.pojo.ark.MessageArk;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息相关接口
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/8 16:15
 */
public class MessageApi extends BaseApi {
    public MessageApi(Boolean isSandBoxMode, String token) {
        super(isSandBoxMode, token);
    }

    /**
     * 发送文本消息
     *
     * @param channelId 子频道ID
     * @param content   文本内容
     * @param messageId 消息ID
     * @return 消息对象
     */
    public Message sendTextMessage(String channelId, String content, String messageId) {
        Map<String, Object> data = new HashMap<>();
        data.put("content", content);
        data.put("msg_id", messageId);
        return getResult(channelId, data);
    }

    /**
     * 发送模板(Ark)消息
     *
     * @param channelId 子频道ID
     * @param ark       MessageArk对象
     * @param messageId 消息ID
     * @return Message对象
     */
    public Message sendTemplateMessage(String channelId, MessageArk ark, String messageId) {
        Map<String, Object> data = new HashMap<>();
        data.put("ark", ark);
        data.put("msg_id", messageId);
        return getResult(channelId, data);
    }

    /**
     * 发送图片消息
     *
     * @param channelId 子频道ID
     * @param image     图片URL
     * @param messageId 消息ID
     * @return 消息对象
     */
    public Message sendImageMessage(String channelId, String image, String messageId) {
        Map<String, Object> data = new HashMap<>();
        data.put("image", image);
        data.put("msg_id", messageId);
        return getResult(channelId, data);
    }

    /**
     * 发送图片消息
     *
     * @param channelId 子频道ID
     * @param content   文本内容
     * @param image     图片URL
     * @param messageId 消息ID
     * @return 消息对象
     */
    public Message sendTextAndImageMessage(String channelId, String content, String image, String messageId) {
        Map<String, Object> data = new HashMap<>();
        data.put("content", content);
        data.put("image", image);
        data.put("msg_id", messageId);
        return getResult(channelId, data);
    }

    private Message getResult(String channelId, Map<String, Object> data) {
        String result = post("/channels/" + channelId + "/messages", data);
        return JSONUtil.toBean(result, Message.class);
    }
}
