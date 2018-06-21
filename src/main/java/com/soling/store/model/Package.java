package com.soling.store.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Package {

    private String appName;

    private String packageName;

    private String appFile;

    private String appIcon;


    public String getAppName() {
        return appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getAppFile() {
        return appFile;
    }

    public String getAppIcon() {
        return appIcon;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setAppFile(String appFile) {
        this.appFile = appFile;
    }

    public void setAppIcon(String appIcon) {
        this.appIcon = appIcon;
    }

    @Override
    public String toString() {
        return "Package{" +
                "appName='" + appName + '\'' +
                ", packageName='" + packageName + '\'' +
                ", appFile='" + appFile + '\'' +
                ", appIcon='" + appIcon + '\'' +
                '}';
    }
}
