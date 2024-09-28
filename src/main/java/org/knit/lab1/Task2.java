package org.knit.lab1;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/***
 * Задача 2
 * Создайте класс SimpleUrl
 * глядя на URL ниже создайте как можно больше полей в классе SimpleUrl:
 * https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText
 * добавьте геттеры и сеттеры для полей
 * Переопределите метод toString() для вывода информации о полях класса:
 * protocol = https
 * address = test.ru
 * domainZone = ru
 * siteName = test
 * webpageName = page.jsp
 * webPageExtention = jsp
 * ....
 * Распарсите данный URL на переменные, создайте экземпляр класса SimpleUrl и выведите на экран
 * Дополнительно
 * попробуйте с другими URL в сети, подумайте как можно сгруппировать значения.
 *
 */
public class Task2 {
    public void execute() {
        class SimpleUrl{
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
                return String.format("protocol = %s\naddress = %s\ndomainZone = %s\nsiteName = %s\nwebpageName = %s\nwebpageExt = %s\nparameters: %s", protocol, address, domainZone, siteName, webpageName, webpageExt, params);
            }
        }


        SimpleUrl url = new SimpleUrl("https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText");
        System.out.println(url);
        url.setAddress("http");
        System.out.println(url.getAddress());

        //todo create class SimpleUrl()
        // SimpleUrl url= new SimpleUrl();
        // url.setAddress(address);
        // url.setProtocol(protocol)
        // System.out.println(url);
    }
}
