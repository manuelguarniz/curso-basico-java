package com.platzi.example.jobsearch;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobPosition {
    private String id;
    private String type;
    private String url;
    @SerializedName("created_at")
    private String createdAt;
    private String company;
    @SerializedName("company_url")
    private String companyUrl;
    private String title;
    private String location;
    private String description;
    @SerializedName("company_logo")
    private String companyLogo;

    @Override
    public String toString() {
        return "JobPosition{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", company='" + company + '\'' +
                ", companyUrl='" + companyUrl + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", companyLogo='" + companyLogo + '\'' +
                '}';
    }
}
