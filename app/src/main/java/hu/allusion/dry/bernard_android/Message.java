package hu.allusion.dry.bernard_android;


import org.json.JSONException;
import org.json.JSONObject;

public class Message {
    private Long mId;
    private String mMessage;

//    public Message (Long id, String message) {
//        this.id = id;
//        this.message = message;
//
//    }

    public static Message fromJson(JSONObject jsonObject){
        try {
            Message message = new Message();
            message.mId = jsonObject.getLong("id");
            message.mMessage = jsonObject.getString("name");
            return message;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }
}
