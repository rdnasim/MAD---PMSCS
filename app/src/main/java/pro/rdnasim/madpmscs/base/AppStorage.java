package pro.rdnasim.madpmscs.base;

import java.util.ArrayList;
import java.util.List;

import pro.rdnasim.madpmscs.model.DivisionDisUpoResult;
import pro.rdnasim.madpmscs.model.DivisionsResult;

public class AppStorage {

    private List<DivisionsResult> divisionsResults = new ArrayList<>();
    private List<DivisionDisUpoResult> divisionDisUpoResults = new ArrayList<>();
    private List<String> upazilla = new ArrayList<>();
    String divisionName;
    String upozillahName;
    String coordinate;
    String district;

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List<DivisionsResult> getDivisionsResults() {
        return divisionsResults;
    }

    public void setDivisionsResults(List<DivisionsResult> divisionsResults) {
        this.divisionsResults = divisionsResults;
    }

    public List<DivisionDisUpoResult> getDivisionDisUpoResults() {
        return divisionDisUpoResults;
    }

    public void setDivisionDisUpoResults(List<DivisionDisUpoResult> divisionDisUpoResults) {
        this.divisionDisUpoResults = divisionDisUpoResults;
    }

    public List<String> getUpazilla() {
        return upazilla;
    }

    public void setUpazilla(List<String> upazilla) {
        this.upazilla = upazilla;
    }

    public String getUpozillahName() {
        return upozillahName;
    }

    public void setUpozillahName(String upozillahName) {
        this.upozillahName = upozillahName;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
