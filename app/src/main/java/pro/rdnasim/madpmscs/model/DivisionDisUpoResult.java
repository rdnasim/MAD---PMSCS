
package pro.rdnasim.madpmscs.model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DivisionDisUpoResult implements Serializable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("district")
    @Expose
    private String district;
    @SerializedName("coordinates")
    @Expose
    private String coordinates;
    @SerializedName("upazilla")
    @Expose
    private List<String> upazilla = null;
    private final static long serialVersionUID = -5311156341505533525L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DivisionDisUpoResult() {
    }

    /**
     * 
     * @param district
     * @param coordinates
     * @param id
     * @param upazilla
     */
    public DivisionDisUpoResult(String id, String district, String coordinates, List<String> upazilla) {
        super();
        this.id = id;
        this.district = district;
        this.coordinates = coordinates;
        this.upazilla = upazilla;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public List<String> getUpazilla() {
        return upazilla;
    }

    public void setUpazilla(List<String> upazilla) {
        this.upazilla = upazilla;
    }

    @NonNull
    @Override
    public String toString() {
        return district;
    }
}
