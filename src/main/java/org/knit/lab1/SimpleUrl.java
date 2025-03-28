package org.knit.lab1;

import java.util.HashMap;
import java.util.Map;

public class SimpleUrl {
    private String urlValue;
    private String protocol;
    private String address;
    private String domainZone;
    private String siteName;
    private String webpageName;
    private String webpageExt;
    private Map<String, String> params = new HashMap<>();

    public SimpleUrl(String urlValue){
        this.urlValue = urlValue;
        int colonInd = urlValue.indexOf(':');
        int fSlashInd = urlValue.indexOf('/', colonInd + 3);
        if (fSlashInd != -1) {
            int lSlashInd = fSlashInd;
            int paramsStartId = -1;
            for (int i = fSlashInd + 1; i < urlValue.length(); i++) {
                char c = urlValue.charAt(i);
                if (c == '/') {
                    lSlashInd = i;
                } else if (c == '?') {
                    paramsStartId = i;
                    break;
                }
            }
            address = urlValue.substring(colonInd + 3, fSlashInd);
            if (paramsStartId != -1){
                for (String statement : urlValue.substring(paramsStartId + 1).split("&")){
                    String[] parAndVal = statement.split("=");
                    params.put(parAndVal[0], parAndVal[1]);
                }
            }
            else paramsStartId = urlValue.length();
            int extPointInd = urlValue.indexOf('.', lSlashInd, paramsStartId);
            webpageName = urlValue.substring(lSlashInd + 1, paramsStartId);
            if (extPointInd != -1){
                webpageExt = urlValue.substring(extPointInd + 1, paramsStartId);
            }
        }
        else {
            address = urlValue.substring(colonInd + 3);

        }
        protocol = urlValue.substring(0, colonInd);
        int periodInd = address.lastIndexOf(".");
        domainZone = address.substring(periodInd + 1);
        siteName = address.substring(0, periodInd);
    }

    public String getProtocol(){
        return protocol;
    }

    public String getAddress(){
        return address;
    }

    public String getDomainZone(){
        return domainZone;
    }

    public String getSiteName(){
        return siteName;
    }

    public String getWebpageName(){
        return webpageName;
    }

    public String getWebpageExt(){
        return webpageExt;
    }

    public Map<String, String> getParams(){
        return params;
    }

    public void setProtocol(String newProtocol){
        protocol = newProtocol;
    }

    public void setAddress(String newAddress){
        address = newAddress;
    }

    public void setDomainZone(String newDomainZone){
        domainZone = newDomainZone;
    }

    public void setSiteName(String newSiteName){
        siteName = newSiteName;
    }

    public void setWebpageName(String newWebpageName){
        webpageName = newWebpageName;
    }

    public void setWebpageExt(String newWebpageExt){
        webpageExt = newWebpageExt;
    }

    public void setParams(Map<String, String> newParams){
        params = newParams;
    }

    public String toString(){
        return String.format("protocol = %s\naddress" +
                        " = %s\ndomainZone" +
                        " = %s\nsiteName" +
                        " = %s\nwebpageName" +
                        " = %s\nwebpageExt" +
                        " = %s\nparameters: %s",
                protocol,
                address,
                domainZone,
                siteName,
                webpageName,
                webpageExt,
                params);
    }
}
