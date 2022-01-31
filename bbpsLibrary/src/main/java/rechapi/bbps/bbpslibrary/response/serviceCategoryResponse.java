package rechapi.bbps.bbpslibrary.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class serviceCategoryResponse {

    private String status = "";
    private String resText = "";

    @SerializedName("dataList")
    private ArrayList<DataList> serviceList = new ArrayList<>();

    public void setServiceList(ArrayList<DataList> serviceList) {
        this.serviceList = serviceList;
    }

    public ArrayList<DataList> getServiceList() {
        return serviceList;
    }

    public String getResText() {
        return resText;
    }

    public void setResText(String resText) {
        this.resText = resText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public class Params{

        private String dataType="";
        private String maxLength="";
        private String minLength="";
        private Boolean optional=false;
        private String paramName="";

        public Boolean getOptional() {
            return optional;
        }

        public String getDataType() {
            return dataType;
        }

        public String getMaxLength() {
            return maxLength;
        }

        public String getMinLength() {
            return minLength;
        }

        public String getParamName() {
            return paramName;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public void setMaxLength(String maxLength) {
            this.maxLength = maxLength;
        }

        public void setMinLength(String minLength) {
            this.minLength = minLength;
        }

        public void setOptional(Boolean optional) {
            this.optional = optional;
        }

        public void setParamName(String paramName) {
            this.paramName = paramName;
        }

    }

    public class DataList {

        @SerializedName("params")
        private ArrayList<Params> paramsList = new ArrayList<>();

        public ArrayList<Params> getParamsList() {
            return paramsList;
        }

        private String bbpsId = "";

        private String type = "";

        private String name = "";

        private String iconUrl="";

        private String categoryCode;

        public String getCategoryCode() {
            return categoryCode;
        }

        public void setCategoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
        }

        public String getBbpsId() {
            return bbpsId;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public String getName() {
            return name;
        }


        public String getType() {
            return type;
        }

        public void setBbpsId(String bbpsId) {
            this.bbpsId = bbpsId;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setType(String type) {
            this.type = type;
        }


    }
}
