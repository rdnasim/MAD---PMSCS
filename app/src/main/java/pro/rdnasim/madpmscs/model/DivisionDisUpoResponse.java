
package pro.rdnasim.madpmscs.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DivisionDisUpoResponse implements Serializable
{

    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("data")
    @Expose
    private List<DivisionDisUpoResult> data = null;
    private final static long serialVersionUID = 3908840897609689094L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DivisionDisUpoResponse() {
    }

    /**
     * 
     * @param data
     * @param status
     */
    public DivisionDisUpoResponse(Status status, List<DivisionDisUpoResult> data) {
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

    public List<DivisionDisUpoResult> getData() {
        return data;
    }

    public void setData(List<DivisionDisUpoResult> data) {
        this.data = data;
    }

}
