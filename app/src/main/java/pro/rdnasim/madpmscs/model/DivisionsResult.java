
package pro.rdnasim.madpmscs.model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DivisionsResult implements Serializable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("division")
    @Expose
    private String division;
    @SerializedName("divisionbn")
    @Expose
    private String divisionbn;
    @SerializedName("coordinates")
    @Expose
    private String coordinates;
    private final static long serialVersionUID = -1406550876008338143L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DivisionsResult() {
    }

    /**
     * 
     * @param division
     * @param coordinates
     * @param divisionbn
     * @param id
     */
    public DivisionsResult(String id, String division, String divisionbn, String coordinates) {
        super();
        this.id = id;
        this.division = division;
        this.divisionbn = divisionbn;
        this.coordinates = coordinates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DivisionsResult withId(String id) {
        this.id = id;
        return this;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public DivisionsResult withDivision(String division) {
        this.division = division;
        return this;
    }

    public String getDivisionbn() {
        return divisionbn;
    }

    public void setDivisionbn(String divisionbn) {
        this.divisionbn = divisionbn;
    }

    public DivisionsResult withDivisionbn(String divisionbn) {
        this.divisionbn = divisionbn;
        return this;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public DivisionsResult withCoordinates(String coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    @NonNull
    @Override
    public String toString() {
        return division;
    }
}
