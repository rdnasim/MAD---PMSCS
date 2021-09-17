
package pro.rdnasim.madpmscs.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DivisionsResponse implements Serializable
{

    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("data")
    @Expose
    private List<DivisionsResult> data = null;
    private final static long serialVersionUID = -2352732950250996976L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DivisionsResponse() {
    }

    /**
     * 
     * @param data
     * @param status
     */
    public DivisionsResponse(Status status, List<DivisionsResult> data) {
        super();
        this.status = status;
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public DivisionsResponse withStatus(Status status) {
        this.status = status;
        return this;
    }

    public List<DivisionsResult> getData() {
        return data;
    }

    public void setData(List<DivisionsResult> data) {
        this.data = data;
    }

    public DivisionsResponse withData(List<DivisionsResult> data) {
        this.data = data;
        return this;
    }

}
