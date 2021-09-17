
package pro.rdnasim.madpmscs.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status implements Serializable
{

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("date")
    @Expose
    private String date;
    private final static long serialVersionUID = 5594383140736324155L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Status() {
    }

    /**
     * 
     * @param date
     * @param code
     * @param message
     */
    public Status(Integer code, String message, String date) {
        super();
        this.code = code;
        this.message = message;
        this.date = date;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Status withCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Status withMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Status withDate(String date) {
        this.date = date;
        return this;
    }

}
